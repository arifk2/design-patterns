package com.rf.rt.dp.composite_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * display(String indent)
 * 
 * int size()
 */
interface FileSystemNode {

	void display(String indent);

	int getSize();
}

/**
 * Leaf
 */
class File implements FileSystemNode {
	private String name;
	private int size;

	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public void display(String indent) {
		System.out.println(indent + " " + name + " (" + size + " KB)");
	}

	@Override
	public int getSize() {
		return size;
	}
}

class Directory implements FileSystemNode {
	private String name;
	private List<FileSystemNode> children = new ArrayList<>();

	public Directory(String name) {
		this.name = name;
	}

	@Override
	public void display(String indent) {
		System.out.println(indent + "📁 " + name);
		for (FileSystemNode child : children) {
			child.display(indent + " ");
		}
	}

	@Override
	public int getSize() {
		int total = 0;

		for (FileSystemNode child : children) {
			total += child.getSize();
		}
		return total;
	}

	public void add(FileSystemNode node) {
		children.add(node);
	}

	public void remove(FileSystemNode node) {
		children.remove(node);
	}
}

/**
 * 🌳 File System (Files & Directories)
 * 
 * 🛒 Shopping Cart (Products & Bundles)
 * 
 * 🏢 Organization Hierarchy (Employee & Manager)
 * 
 * 🎨 Graphics Editor (Shape & Group)
 * 
 * 📋 Menu System (Menu & Menu Item)
 * 
 * 📦 Amazon Product Categories (Category & Product)
 * 
 * 🌐 HTML DOM (<div>,<body>, <p>)
 * 
 * 
 */
public class FileSystemCompositeDesignPatternDriver {
	public static void main(String[] args) {
		File movie1 = new File("Avenger.mp4", 2000);
		File movie2 = new File("Avatar.mp4", 2000);

		File resume = new File("Resume.pdf", 150);

		Directory marvel = new Directory("Marvel");
		marvel.add(new File("IronMan.mp4", 1780));
		marvel.add(new File("Thor.mp4", 1800));

		Directory movies = new Directory("movies");
		movies.add(movie1);
		movies.add(movie2);

		Directory documents = new Directory("Documents");
		documents.add(resume);

		Directory root = new Directory("C");
		root.add(movies);
		root.add(documents);
		root.add(marvel);

		root.add(new File("Photo.jpg", 500));
		root.display("");

	}
}
