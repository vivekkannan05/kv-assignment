package assignment.kv.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import assignment.kv.generated.Alternative;
import assignment.kv.generated.Node;
import assignment.kv.generated.XmlFile;
import assignment.kv.parser.XMLParser;

public class Main {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final String DOTTED_LINE = "-----------------------------------------------------------";
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final DTree DECISION_TREE = new DTree();

	static {
		loadDecsionTree();
		displayWelcomeText();
		displayMainMenu();
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		for (String nodeName : DECISION_TREE.getFileMap().keySet()) {
			System.out.println(nodeName);
		}

		String inputValue = getInput();

		DECISION_TREE.setParentNode(DECISION_TREE.getFileMap().get(inputValue));

		while (true) {
			List<Alternative> alternativeList = DECISION_TREE.getAlternatives();
			if (!alternativeList.isEmpty()) {
				alternativeList.forEach(s -> System.out.println(s.getName()));
				String input = getInput();
				Optional<Alternative> alter = alternativeList.stream().filter(a -> a.getName().equalsIgnoreCase(input))
						.findFirst();
				if (alter.isPresent()) {
					DECISION_TREE.setParentNode(DECISION_TREE.getChildNode(alter.get().getMapsTo()));
					continue;
				} else {
					System.out.println(
							"The Job terminates here as no further information can be derived for the input mentioned");
					break;
				}
			} else {
				alternativeList = DECISION_TREE.getAlternatives(DECISION_TREE.getParentNode());
				if (alternativeList.isEmpty()) {
					List<XmlFile> xmlList = DECISION_TREE.getParentNode().getXmlFile();
					if (!xmlList.isEmpty()) {
						xmlList.stream().forEach(s -> System.out.println(s.getNodeName()));
						inputValue = getInput();
						DECISION_TREE.switchNode(inputValue);
						continue;
					} else {
						System.out.println("There is no more options available");
						break;
					}
				} else {
					alternativeList.forEach(s -> System.out.println(s.getName()));
					System.out.println("Operation is complete");
					break;
				}
			}
		}

	}

	public static String getInput() {
		System.out.println(LINE_SEPARATOR);
		System.out.println(DOTTED_LINE);
		System.out.println("Please enter from one of the options provided");
		return SCANNER.nextLine();
	}

	public static void loadDecsionTree() {
		List<String> fileList = Arrays.asList("src/NewFile.xml", "src/PROCESSUNKNOWN.XML");
		for (String str : fileList) {
			Node node = XMLParser.parse(str);
			DECISION_TREE.addToFileMap(node.getName(), node);
			// System.out.println(node.getName());
		}

	}

	private static void displayWelcomeText() {
		System.out.println("***********************************************************");
		System.out.println("                    WELCOME TO THE APP                     ");
		System.out.println("***********************************************************");
	}

	private static void displayMainMenu() {
		System.out.println(
				LINE_SEPARATOR + LINE_SEPARATOR + "This application provides options to query and to get result");
	}
}
