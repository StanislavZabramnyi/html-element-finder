package com.zabramnyi.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class ElementFinder {

    private static String CHARSET_NAME = "utf-8";

    public static String findElement(File htmlFile, Element target) {
        Element findingElement = findTheMostSimilarElement(getElementsFromHtmlFile(htmlFile).get(), target);
        return getPathToElement(findingElement);
    }

    private static String getPathToElement(Element element) {
        Elements parents = element.parents();
        Collections.reverse(parents);

        return parents.stream()
                .map(el -> el.tagName() + "[" + el.elementSiblingIndex() + "]" + ">")
                .collect(Collectors.joining(" ")) + element.tagName() + element.elementSiblingIndex();
    }

    private static Optional<Elements> getElementsFromHtmlFile(File htmlFile) {
        try {
            Document doc = Jsoup.parse(
                    htmlFile,
                    CHARSET_NAME,
                    htmlFile.getAbsolutePath());

            return Optional.of(doc.body().getAllElements());

        } catch (IOException e) {

            return Optional.empty();
        }
    }

    private static Element findTheMostSimilarElement(Elements elements, Element target) {

        int maxCountOfSimilarAttributes = 0;

        Element maxSimilarElement = elements.first();
        for (Element e : elements) {
            int count = amountOfIdenticalAttributes(e, target);
            if (count > maxCountOfSimilarAttributes) {
                maxSimilarElement = e;
                maxCountOfSimilarAttributes = count;
            }
        }
        return maxSimilarElement;
    }

    private static int amountOfIdenticalAttributes(Element element, Element target) {

        Attributes elementAttributes = element.attributes();
        Attributes targetAttributes = target.attributes();

        int counter = 0;
        for (Attribute a : elementAttributes) {
            for (Attribute aTarget : targetAttributes) {
                if (a.equals(aTarget)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}


