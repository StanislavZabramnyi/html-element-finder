Please use next template to run application:
> java -jar <path_to_jar> htmlElementFinder-1.0-SNAPSHOT-jar-with-dependencies.jar <elements_id> <input_origin_file_path> <input_other_sample_file_path> 

 where:
<path_to_jar> - path to folder where htmlElementFinder-1.0-SNAPSHOT-jar-with-dependencies.jar is located;
 
<elements_id> - id of element that you want to find;
 
<input_origin_file_path> - origin sample path to find the element with attribute id = <elements_id>   and collect all the required information;
 
<input_other_sample_file_path> - path to diff-case HTML file to search a similar element;

Name of origin html file is "sample-0-origin.html"

Names of differet samles:
sample-1-evil-gemini.html;
sample-2-container-and-clone.html;
sample-3-the-escape.html;
sample-4-the-mash.html;

All files you can find in "samples" folder.
