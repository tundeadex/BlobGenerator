//package com.caplin.example;


/**
 * Text blob generator takes an instruction string
 *
 * Generates a blob of text using the characters a to f, (should loop back to a if number of letters to be generated is more than 6)
 *
 * Then pads the blob with dashes to either the left or right depending on the padding style,
 *
 * or no padding if no padding style defined
 *
 * eg. if input instruction string:
 * 		addLettersFor:3-loops,padLeftFor:5-loops,padRightFor:6-loops,paddingStyle:left
 * output should be:
 * 		-----abc
 *
 * eg. if input instruction string:
 * 		addLettersFor:8-loops,padLeftFor:5-loops,padRightFor:7-loops,paddingStyle:right
 * output should be:
 * 		abcdefab-------
 *
 * eg. if input instruction string:
 * 		addLettersFor:8-loops,padLeftFor:5-loops,padRightFor:7-loops
 * output should be:
 * 		abcdefab
 *
 * 1) fix the compile issues and run the main method
 *
 * 2) correct any mistakes in logic
 *
 * 3) Make the code cleaner (refactor and simplify classes)
 *
 * 4) test that it works as intended
 */
public class TextBlobGenerator {


	private String[] letterss = {"a","b", "c", "d", "e", "f"};



	private final int addLettersFor;
	private int padLeftFor;
	private int padRightFor;


	String paddingStyle;

	private String blob;

	public TextBlobGenerator() {

		String instructions = "6,8,6,paddingStyle:left";
//		String instructions = "addLettersFor:9-loops,padLeftFor:99-loops,padRightFor:999-loops,paddingStyle:left";

		addLettersFor = Integer.parseInt(instructions.split(",")[0]);
		padLeftFor = Integer.parseInt(instructions.split(",")[1]);
		padRightFor = Integer.parseInt(instructions.split(",")[2]);
		paddingStyle = (instructions.split(",")[3]).split(":")[1];
		blob = "";

		
		if(paddingStyle.trim() == "left")
		{

			for(int i=0; i<addLettersFor; i++){
				blob = letterss[i] + blob;
			}

			for(int i=0; i<padLeftFor; i++){
			   blob = "=" + blob;
			}
				

		} 
	

		else{

			for(int j=0; j<addLettersFor; j++){
			
				blob=letterss[j] + blob;
			}

			for(int j=0; j<padRightFor; j++){
				blob = blob + "=";
			}
				
		}

	}

	public String getBlob() {
		return blob;
	}


	public static void main(String[] args) {
		System.out.println(new TextBlobGenerator().getBlob());

	}


}
