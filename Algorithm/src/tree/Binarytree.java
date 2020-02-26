package tree;

import com.sun.org.apache.regexp.internal.RE;

public class Binarytree     {
    Node root;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    public void frontshow(){
        root.frontshow();
    }
    public void midshow(){
        if (root!=null){
        root.midshow();}
    }



}
