package com.designpattern.FlyWeight;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyWeightTest {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,4,TreeFactory.getTree("t1", "t1 data"));
        TreeNode treeNode2 = new TreeNode(8,4,TreeFactory.getTree("t1", "t1 data"));

        TreeNode treeNode3 = new TreeNode(3,4,TreeFactory.getTree("t2", "t1 data"));
        TreeNode treeNode4 = new TreeNode(8,9,TreeFactory.getTree("t2", "t1 data"));
    }
}

class TreeNode{
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}

class TreeFactory{
    private static Map<String, Tree> map=new ConcurrentHashMap<>();

    public static Tree getTree(String name, String data){
        if(map.containsKey(name)){
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }


}


class Tree{
    private final String name;
    private final String data;

    public Tree(String name, String data){
        System.out.println(name+" is created");
        this.name = name;
        this.data =data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

}

