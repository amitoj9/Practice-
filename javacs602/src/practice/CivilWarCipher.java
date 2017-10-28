package practice;



public class CivilWarCipher {

	public String key;
	
	public Alphabet alphabet = null;
	
	public CivilWarCipher(String key, Alphabet alphabet) {
		this.key = key;
		this.alphabet = alphabet;
	}

	public String encrypt(String text) {
		text=removeNotValidChars(text);
		String keyRep=generateKeyRep(text);
		char encodedArray[]=new char[text.length()];
		for(int i=0;i<text.length();i++)
		{
			encodedArray[i]=addKeyAndTextValue(keyRep.charAt(i),text.charAt(i));
		}
		return String.valueOf(encodedArray);
	}
	
	public char addKeyAndTextValue(char key,char text)
	{
		int num=0;
		char retChar=' ';
		if (text>=65&&text<=91)
		{
			Alphabet upp=Alphabet.UPPPERCASE_QWERTY;
			String up=String.valueOf(upp.validChars);
			if(key>=48&& key<=58)
			{
				num=Integer.parseInt(Character.toString(key))+up.indexOf(text);
			}
			else
			{
				key=Character.toUpperCase(key);
				num=up.indexOf(key)+up.indexOf(text);
				
			}
			num=num%26;
			retChar=up.charAt(num);
		}
		if(text>=97&&text<=123)
		{

			Alphabet low=Alphabet.LOWERCASE_QWERTY;
			String lo=String.valueOf(low.validChars);
			if(key>=48&& key<=58)
			{
				num=Integer.parseInt(Character.toString(key))+lo.indexOf(text);
			}
			else
			{
				key=Character.toLowerCase(key);
				num=lo.indexOf(key)+lo.indexOf(text);
			}
			
			num=num%26;
			retChar=lo.charAt(num);
		}
		if(text>=48 && text<=58)
		{
			if(key>=48&& key<=58)
			{
				num=Integer.parseInt(Character.toString(text))+Integer.parseInt(Character.toString(key));
			}
			else {
				Alphabet upp=Alphabet.UPPPERCASE_QWERTY;
				String up=String.valueOf(upp.validChars);
				key=Character.toUpperCase(key);
				int keyTemp=up.indexOf(key)%20;
				num=Integer.parseInt(Character.toString(text))+keyTemp;
				
			}
			retChar=(char)num;
		}
		return retChar;
	}
	

	public String decrypt(String text) {
		String keyRep=generateKeyRep(text);
		char decryptedArray[]=new char[text.length()];
		for(int i=0;i<text.length();i++)
		{
			decryptedArray[i]=retriveTextValue(keyRep.charAt(i),text.charAt(i));
		}
		return String.valueOf(decryptedArray);
	}
	public char retriveTextValue(char key,char text)
	{
	 char retChar=' ';
	 int num=0;
	 if (text>=65&&text<=91)
		{
			Alphabet upp=Alphabet.UPPPERCASE_QWERTY;
			String up=String.valueOf(upp.validChars);
			if(key>=48&& key<=58)
			{
				num=up.indexOf(text)-Integer.parseInt(Character.toString(key));
			}
			else
			{
				key=Character.toUpperCase(key);
				num=up.indexOf(text)-up.indexOf(key);
				
			}
			num=num%26;
			if(num<0)
			{
				num=up.length()+num;
			}
			retChar=up.charAt(num);
		}
	 if(text>=97&&text<=123)
		{
			Alphabet low=Alphabet.LOWERCASE_QWERTY;
			String lo=String.valueOf(low.validChars);
			if(key>=48&& key<=58)
			{
				num=lo.indexOf(text)-Integer.parseInt(Character.toString(key));
			}
			else
			{
				key=Character.toLowerCase(key);
				num=lo.indexOf(text)-lo.indexOf(key);
				
			}
			num=num%26;
			if(num<0)
			{
				num=lo.length()+num;
			}
			retChar=lo.charAt(num);
		}
	 if(text<=58)
		{
			if(key>=48&& key<=58)
			{
				num=text-Integer.parseInt(Character.toString(key));
			}
			else {
				Alphabet upp=Alphabet.UPPPERCASE_QWERTY;
				String up=String.valueOf(upp.validChars);
				key=Character.toUpperCase(key);
				int keyTemp=up.indexOf(key)%20;
				num=(int)text-keyTemp;
				
			}
			num=num+48;
			retChar=(char)num;
		}
	 return retChar;
	}
	public String removeNotValidChars(String text)
	{
		int countSpace=0;
		for(int i=0;i<text.length();i++)
		{
			if(!searchChar(text.charAt(i)))
			{
				countSpace++;
			}
		}
		char textArr[]= new char[text.length()-countSpace];
		int textArrCount=0;
		for(int i=0;i<text.length();i++)
		{
			if(searchChar(text.charAt(i)))
			{
				textArr[textArrCount]=text.charAt(i);
				textArrCount++;
			}
		}
		return String.valueOf(textArr);
	}
	public  boolean searchChar(char a)
	{
		for(int i=0;i<alphabet.validChars.length;i++)
		{
			if(a==alphabet.validChars[i])
			{
				return true;
			}
		}
		return false;
	}
	public String generateKeyRep(String text)
	{
		char keyArr[]= new char[text.length()];
		int countKey=0;
		
		for(int i=0;i<text.length();i++)
		{
			if(countKey>key.length()-1)
			{
				countKey=0;
			}
			keyArr[i]=key.charAt(countKey);
			countKey++;
		}
		return String.valueOf(keyArr);
	}
}
