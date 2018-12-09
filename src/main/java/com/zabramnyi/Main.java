package com.zabramnyi;

import com.zabramnyi.util.ElementFinder;
import com.zabramnyi.util.JsoupFindById;
import org.jsoup.nodes.Element;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String TARGET_ELEMENT_ID = args[0];

        File originFile = new File(args[1]);
        File differenceFile = new File(args[2]);

        Element targetElement = JsoupFindById.findElementById(originFile, TARGET_ELEMENT_ID).get();

        System.out.println(ElementFinder.findElement(differenceFile, targetElement));

    }
}
