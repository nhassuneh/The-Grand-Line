package tgl;

import java.io.Serializable;

class Node implements Serializable{
    Island island;

    Node left;
    Node right;

    public Node(Island item) {
        island = item;
        left = right = null;
    }

}

public class Map implements Serializable{
    Node root;

    Map(Island island) {
        root = new Node(island);
    }

    Map() {
        root = null;
    }

    public void populate() {
        // central Island
        Island redLine = new Island("Red Line", "Akainu", 8);
        Node centralPoint = new Node(redLine);
        // Final Island
        Island laughTale = new Island("Laugh Tale", "No Villain", 15);
        Node finalIsland = new Node(laughTale);
        // 1
        Island reverseMountain = new Island("Reverse Mountain", "Laboon", 1);
        root = new Node(reverseMountain);
        // 2
        Island drumIsland = new Island("Drum Island", "Wapol", 2);
        root.left = new Node(drumIsland);
        // 3
        Island alabasta = new Island("Alabasta", "Crocodile", 3);
        root.right = new Node(alabasta);
        // 4
        Island jaya = new Island("Jaya", "Bellamy", 4);
        root.left.right = new Node(jaya);
        // 5
        Island skypiea = new Island("Skypiea", "Enel", 5);
        root.left.left = new Node(skypiea);
        // 6
        Island water7 = new Island("Water 7", "CP9", 6);
        root.right.left = new Node(water7);
        // 7
        Island enniesLobby = new Island("Ennies Lobby", "Rob Lucci", 7);
        root.right.right = new Node(enniesLobby);
        // 8
        root.right.right.left = centralPoint;
        root.right.right.right = centralPoint;

        root.right.left.left = centralPoint;
        root.right.left.right = centralPoint;

        root.left.right.right = centralPoint;
        root.left.right.left = centralPoint;

        root.left.left.left = centralPoint;
        root.left.left.right = centralPoint;
        // 9
        Island sabaody = new Island("Sabaody", "Kizaru", 9);
        centralPoint.left = new Node(sabaody);
        // 10
        Island fishmanIsland = new Island("Fishman Island", "Hody Jones", 10);
        centralPoint.right = new Node(fishmanIsland);
        // 11
        Island dressrossa = new Island("Dressrossa", "Donquixote Doflamingo", 11);
        centralPoint.left.right = new Node(dressrossa);
        // 12
        Island wholeCake = new Island("Whole Cake", "Big Mom", 12);
        centralPoint.left.left = new Node(wholeCake);
        // 13
        Island wanoKuni = new Island("Wano Kuni", "Kaido", 13);
        centralPoint.right.left = new Node(wanoKuni);
        // 14
        Island punkHazard = new Island("Punk Hazard", "Ceaser", 14);
        centralPoint.right.right = new Node(punkHazard);
        // 15
        centralPoint.right.right.left = finalIsland;
        centralPoint.right.right.right = finalIsland;

        centralPoint.right.left.left = finalIsland;
        centralPoint.right.left.right = finalIsland;

        centralPoint.left.right.right = finalIsland;
        centralPoint.left.right.left = finalIsland;

        centralPoint.left.left.left = finalIsland;
        centralPoint.left.left.right = finalIsland;

    }

    public Node getIsland(){
        return root;
    }

    public void setIsland(Node branch){
        root = branch;
    }
}
