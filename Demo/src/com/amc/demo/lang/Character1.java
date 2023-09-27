package com.amc.demo.lang;
public class Character1
{

    public static void main (String [] args)
    {

        Character chObject = new Character('\u09E6');
		char ch = chObject.charValue();

       //Printing static final field values
        System.out.println(
            "Printing static final fields for a Character Class .. \n"+
            "Character.COMBINING_SPACING_MARK : "+Character.COMBINING_SPACING_MARK+" "+ "\n"+
            "Character.CONNECTOR_PUNCTUATION  : "+Character.CONNECTOR_PUNCTUATION +" "+ "\n"+
            "Character.CONTROL                : "+Character.CONTROL               +" "+ "\n"+
            "Character.CURRENCY_SYMBOL        : "+Character.CURRENCY_SYMBOL       +" "+ "\n"+
            "Character.DASH_PUNCTUATION       : "+Character.DASH_PUNCTUATION      +" "+ "\n"+
            "Character.DECIMAL_DIGIT_NUMBER   : "+Character.DECIMAL_DIGIT_NUMBER  +" "+ "\n"+
            "Character.ENCLOSING_MARK         : "+Character.ENCLOSING_MARK        +" "+ "\n"+
            "Character.END_PUNCTUATION        : "+Character.END_PUNCTUATION       +" "+ "\n"+
            "Character.FORMAT                 : "+Character.FORMAT                +" "+ "\n"+
            "Character.LETTER_NUMBER          : "+Character.LETTER_NUMBER         +" "+ "\n"+
            "Character.LINE_SEPARATOR         : "+Character.LINE_SEPARATOR        +" "+ "\n"+
            "Character.LOWERCASE_LETTER       : "+Character.LOWERCASE_LETTER      +" "+ "\n"+
            "Character.MATH_SYMBOL            : "+Character.MATH_SYMBOL           +" "+ "\n"+
            "Character.MAX_RADIX              : "+Character.MAX_RADIX             +" "+ "\n"+
            "Character.MAX_VALUE              : "+Character.MAX_VALUE             +" "+ "\n"+
            "Character.MIN_RADIX              : "+Character.MIN_RADIX             +" "+ "\n"+
            "Character.MIN_VALUE              : "+Character.MIN_VALUE             +" "+ "\n"+
            "Character.MODIFIER_LETTER        : "+Character.MODIFIER_LETTER       +" "+ "\n"+
            "Character.MODIFIER_SYMBOL        : "+Character.MODIFIER_SYMBOL       +" "+ "\n"+
            "Character.NON_SPACING_MARK       : "+Character.NON_SPACING_MARK      +" "+ "\n"+
            "Character.OTHER_LETTER           : "+Character.OTHER_LETTER          +" "+ "\n"+
            "Character.OTHER_NUMBER           : "+Character.OTHER_NUMBER          +" "+ "\n"+
            "Character.OTHER_PUNCTUATION      : "+Character.OTHER_PUNCTUATION     +" "+ "\n"+
            "Character.OTHER_SYMBOL           : "+Character.OTHER_SYMBOL          +" "+ "\n"+
            "Character.PARAGRAPH_SEPARATOR    : "+Character.PARAGRAPH_SEPARATOR   +" "+ "\n"+
            "Character.PRIVATE_USE            : "+Character.PRIVATE_USE           +" "+ "\n"+
            "Character.SPACE_SEPARATOR        : "+Character.SPACE_SEPARATOR       +" "+ "\n"+
            "Character.START_PUNCTUATION      : "+Character.START_PUNCTUATION     +" "+ "\n"+
            "Character.SURROGATE              : "+Character.SURROGATE             +" "+ "\n"+
            "Character.TITLECASE_LETTER       : "+Character.TITLECASE_LETTER      +" "+ "\n"+
            "Character.TYPE                   : "+Character.TYPE                  +" "+ "\n"+
            "Character.UNASSIGNED             : "+Character.UNASSIGNED            +" "+ "\n"+
            "Character.UPPERCASE_LETTER       : "+Character.UPPERCASE_LETTER      +" "+ "\n"
            );

	   try
	   {
	 		ch = args[0].charAt(0);
	   } catch (ArrayIndexOutOfBoundsException e)
	   {
	 		System.out.print("Usage Character1 <ch>\n"+
				"Using default character 'C'\n");
	   }

       System.out.println("Character ch : "+ch);

	   if (Character.isDefined(ch))
		 {
   			System.out.println("Identifier defined in Unicode");
		 }
	   if (Character.isLetterOrDigit(ch))
		 {
   			System.out.println("Identifier is a letter or a digit");
		 }
	   if (Character.isDigit(ch))
		 {
   			System.out.println("Identifier is a digit");
		 }
	   if (Character.isLetter(ch))
		 {
   			System.out.println("Identifier is a letter");
		 }
	   if (Character.isSpaceChar(ch))
		 {
   			System.out.println("Identifier is a unicode space character");
		 }
	   if (Character.isWhitespace(ch))
		 {
   			System.out.println("Identifier is a white-space");
		 }
	   if (Character.isLowerCase(ch))
		 {
   			System.out.println("Identifier is a lowercase letter");
		 }
	   if (Character.isUpperCase(ch))
		 {
   			System.out.println("Identifier is a uppercase letter");
		 }
	   if (Character.isTitleCase(ch))
		 {
   			System.out.println("Identifier is a titlecase letter");
		 }

    }
}

