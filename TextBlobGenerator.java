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
	static String instructions;

	public TextBlobGenerator() {

		addLettersFor = getNumberOfLetters(instructions);
		padLeftFor = getNumberOfLeftPadding(instructions);
		padRightFor = getNumberOfRightPadding(instructions);
		paddingStyle = getPaddingStyle(instructions);
		blob = "";

		for(int i=0; i<addLettersFor; i++){
			blob = blob + letterss[i];
		}

		if(paddingStyle.equals("left"))
		{
			for(int i=0; i<padLeftFor; i++){
				blob = "=" + blob;
			}
		}
		else if (paddingStyle.equals("right")){
			for(int j=0; j<padRightFor; j++){
				blob = blob + "=";
			}
		}
	}

	public String getBlob() {
		return blob;
	}

	public String getPaddingStyle(String inst){
		if(numberOfInstructions(inst) < 4){
			return "none";
		}
		else{
			String firstSplit = inst.split(",")[3];
			String secSplit= firstSplit.split(":")[1];
			return secSplit;
		}
	}

	public int numberOfInstructions(String inst){
		int count = inst.split(",").length;
		return count;
	}

	public int getNumberOfLetters(String inst){
		String str = tidyUp(inst).split(",")[0];
		return Integer.parseInt(str.split(":")[1]);
	}

	public int getNumberOfLeftPadding(String inst){
		String str = tidyUp(inst).split(",")[1];
		return Integer.parseInt(str.split(":")[1]);
	}

	public int getNumberOfRightPadding(String inst){
		String str = tidyUp(inst).split(",")[2];
		return Integer.parseInt(str.split(":")[1]);
	}

	public static String tidyUp(String inst){
		return inst.replace("-loops", "");
	}

	public static void main(String[] args) {
		instructions = "addLettersFor:6-loops,padLeftFor:4-loops,padRightFor:4-loops";
//		instructions = "addLettersFor:4-loops,padLeftFor:10-loops,padRightFor:5-loops,paddingStyle:left";
//		instructions = "addLettersFor:3-loops,padLeftFor:10-loops,padRightFor:5-loops,paddingStyle:right";
		System.out.println(new TextBlobGenerator().getBlob());
	}


}
