package LinkedList;

import Business.Business;

public class Node{

    Node next;
    Business objBusiness;

    public Node (Business objBusiness){
        this.objBusiness = objBusiness;
        this.next = null;

    }

    public Business getObjBusiness() {
        return objBusiness;
    }
}