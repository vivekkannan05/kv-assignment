package assignment.kv.main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import assignment.kv.generated.Alternative;
import assignment.kv.generated.Mappinglist;
import assignment.kv.generated.Node;

public class DTree {

	private Node currentNode;

	private Map<String, Node> fileMap;

	public DTree() {
		fileMap = new HashMap<>();
	}

	public void setParentNode(Node node) {
		this.currentNode = node;
	}
	 public Node getParentNode(){
		Optional<Node> node = Optional.ofNullable(currentNode);
		 return node.isPresent()?node.get():new Node();
	 }

	public void addToFileMap(String identifier, Node node) {
		this.fileMap.putIfAbsent(identifier, node);
	}
	
	public Map<String, Node> getFileMap(){
		return fileMap;
	}

	public void switchNode(String identifier) {
		this.currentNode = this.fileMap.getOrDefault(identifier, new Node());
	}

	public List<Alternative> getAlternatives() {
		if(null == currentNode){
			return Collections.emptyList();
		}
		Optional<Mappinglist> mappingList = Optional.ofNullable(currentNode.getMappinglist());
		return mappingList.isPresent()? mappingList.get().getAlternative():Collections.emptyList();
	}
	
	public Node getChildNode(String nodeName) {
		Optional<Node> node = this.currentNode.getChildrennodes().getNode().parallelStream()
				.filter(n -> n.getName().equalsIgnoreCase(nodeName)).findFirst();
		return node.isPresent()? node.get(): null;
	}

	public List<Alternative> getAlternatives(Node node) {
		if(null == node){
			return Collections.emptyList();
		}
		return node.getAlternative();
	}
}
