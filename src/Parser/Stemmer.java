package Parser;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


public class Stemmer {
	/**
	 * The program will be run using the following command:<p>
	 * {@code Stemmer rulesfile inputfile}.
	 */
	public static void main(String[] args) {
		//assert(args.length==2);
		int line_w=0;
		String ruleFilePath=args[0];
		String inputFilePath;//=args[1];
		inputFilePath="post.txt";
		String inputFilePath1="comment.txt";
		//String inputFilePath=
		RuleFileParser parser = new RuleFileParser(ruleFilePath);
		String outputFile="F:\\L4T1\\Thesis\\jawad\\bangla_pos_tagger_abhishek\\bangla_pos_tagger-master\\stem.txt";
		String outputFile1="F:\\L4T1\\Thesis\\jawad\\bangla_pos_tagger_abhishek\\bangla_pos_tagger-master\\stem1.txt";
		File file = new File(inputFilePath);
		File file1 = new File(inputFilePath1);
		File file2=new File(outputFile);
		File file3=new File(outputFile1);
		BufferedWriter writer= null,writer1=null;

		try {
			writer = new BufferedWriter(new FileWriter(file2));
			writer1 = new BufferedWriter(new FileWriter(file3));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader inputFileReader = 
				new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = inputFileReader.readLine()) != null) {
				int len=line.length();
				for(int i=0;i<len;i++){
					if(line.charAt(i)==',') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='?') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='।') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='.') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)==';') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='!') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)==':') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='-') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='(') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)==')') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='\'') line=line.substring(0,i)+line.substring(i+1,len);
					len=line.length();
				}
				len=line.length();
				for(int i=0;i<len;i++) {
					if (line.charAt(i) == '?') line = line.substring(0, i) + line.substring(i + 1, len);
					else if (line.charAt(i) == '(') line = line.substring(0, i) + line.substring(i + 1, len);
					len=line.length();
				}
				len=line.length();
				if (len>0) {
					if(line.charAt(len-1) == '!') line = line.substring(0, len-1);// + line.substring(i + 1, len);

				}
				System.out.println(line);
				for (String word : line.split("[\\s।%,ঃ]+")) {
					System.out.print(parser.stemOfWord(word) + " ");
					writer.write(parser.stemOfWord(word) + " ");
					line_w++;
					if(line_w==10) {writer.write("\n");line_w=0;}

				}
				System.out.println();
			}
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}




///////////////////////////////////////////////////////////////////////////////////////

		try (BufferedReader inputFileReader1 =
					 new BufferedReader(new FileReader(file1))) {
			String line;
			while ((line = inputFileReader1.readLine()) != null) {
				int len=line.length();
				for(int i=0;i<len;i++){
					if(line.charAt(i)==',') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='?') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='।') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='.') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)==';') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='!') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)==':') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='-') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='(') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)==')') line=line.substring(0,i)+line.substring(i+1,len);
					else if(line.charAt(i)=='\'') line=line.substring(0,i)+line.substring(i+1,len);
					len=line.length();
				}
				len=line.length();
				for(int i=0;i<len;i++) {
					if (line.charAt(i) == '?') line = line.substring(0, i) + line.substring(i + 1, len);
					else if (line.charAt(i) == '(') line = line.substring(0, i) + line.substring(i + 1, len);
					len=line.length();
				}
				len=line.length();
				if (len>0) {
					if(line.charAt(len-1) == '!') line = line.substring(0, len-1);// + line.substring(i + 1, len);

				}
				System.out.println(line);
				for (String word : line.split("[\\s।%,ঃ]+")) {
					System.out.print(parser.stemOfWord(word) + " ");
					writer1.write(parser.stemOfWord(word) + " ");
					//line_w++;
					//if(line_w==10) {writer1.write("\n");line_w=0;}

				}
				writer1.write("\n");
				System.out.println();
			}
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}


////////////////////////////////////////////////////////////////////////////////////


		try {
			writer.close();
			writer1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
