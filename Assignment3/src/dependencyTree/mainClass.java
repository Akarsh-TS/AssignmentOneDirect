package dependencyTree;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class mainClass {

    private static int option;
    private static Scanner sc;
    private static Node[] nodes;
    private static int count;
    private static int i;
    public static void main(String args[]) {
        nodes = new Node[50];
        count = 0;
        sc = new Scanner(System.in);

        System.out.println("Options: \n1.create nodes.\r\n" +
                "2.Add dependency.\r\n" +
                "3.Get children\r\n" +
                "4.Get parents\r\n" +
                "5.Get ancestors\r\n" +
                "6.Get descendants\r\n" +
                "7.Delete Dependency\r\n" +
                "8.Delete Nodes\r\n" +
                "9.Exit\r\n");
        option = Integer.parseInt(sc.nextLine());
//        while (option < 9) {
//            int i;
//            if (option == 1) {
//                HashMap<String, String> hmap = new HashMap<String, String>();
//                nodes[count] = new Node();
//                System.out.println("Enter node name:");
//                String name = sc.nextLine();
//                System.out.println("Enter number of Additional info:");
//                int len = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < len; i++) {
//                    System.out.println("Enter key:");
//                    String key = sc.nextLine();
//                    System.out.println("Enter value:");
//                    String value = sc.nextLine();
//                    hmap.put(key, value);
//                }
//                nodes[count].Nodecreate(name, hmap);
//                count++;
//            } else if (option == 2) {
//                Node parent = new Node();
//                Node child = new Node();
//                System.out.println("Enter the parent node id:");
//                Integer id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            parent = nodes[i];
//                        }
//                    }
//                }
//                System.out.println("Enter the child node id:");
//                id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            child = nodes[i];
//                        }
//                    }
//                }
//                parent.AddDependency(child);
//            } else if (option == 3) {
//                List<Node> children;
//                Node parent = new Node();
//                System.out.println("Enter the parent node id:");
//                Integer id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            parent = nodes[i];
//                        }
//                    }
//                }
//                children = parent.getchildren();
//                for (Node j : children) {
//                    System.out.println(j.NodeId);
//                }
//
//            } else if (option == 4) {
//                List<Node> parent;
//                Node child = new Node();
//                System.out.println("Enter the child node id:");
//                Integer id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            child = nodes[i];
//                        }
//                    }
//                }
//                parent = child.getparent();
//                for (Node j : parent) {
//                    System.out.println(j.NodeId);
//                }
//            } else if (option == 5) {
//                List<Node> ancestors;
//                Node child = new Node();
//                System.out.println("Enter the node id:");
//                Integer id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            child = nodes[i];
//                        }
//                    }
//                }
//                ancestors = child.getancestors();
//                for (Node j : ancestors) {
//                    System.out.println(j.NodeId);
//                }
//            } else if (option == 6) {
//                List<Node> descendants;
//                Node parent = new Node();
//                System.out.println("Enter the node id:");
//                Integer id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            parent = nodes[i];
//                        }
//                    }
//                }
//                descendants = parent.getdescendants();
//                for (Node j : descendants) {
//                    System.out.println(j.NodeId);
//                }
//            } else if (option == 7) {
//                Node parent = new Node();
//                Node child = new Node();
//                System.out.println("Enter the parent node id:");
//                Integer id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            parent = nodes[i];
//                        }
//                    }
//                }
//                System.out.println("Enter the child node id:");
//                id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            child = nodes[i];
//                        }
//                    }
//                }
//                parent.deleteDependency(child);
//
//            } else if (option == 8) {
//                Node node = new Node();
//                System.out.println("Enter the node id:");
//                Integer id = Integer.parseInt(sc.nextLine());
//                for (i = 0; i < count; i++) {
//                    if (nodes[i] != null) {
//                        if (nodes[i].NodeId.equals(id)) {
//                            node = nodes[i];
//                            break;
//                        }
//                    }
//                }
//                node.deleteNode();
//                nodes[i] = null;
//            }
//
//
//            System.out.println("Options: \n1.create nodes.\r\n" +
//                    "2.Add dependency.\r\n" +
//                    "3.Get children\r\n" +
//                    "4.Get parents\r\n" +
//                    "5.Get ancestors\r\n" +
//                    "6.Get descendants\r\n" +
//                    "7.Delete Dependency\r\n" +
//                    "8.Delete Nodes\r\n" +
//                    "9.Exit\r\n");
//
//            option = Integer.parseInt(sc.nextLine());
//        }
    }

    public static void query(){
        {
            if (option == 1) {
                executeOption1();

            } else if (option == 2) {
                executeOption2();

            } else if (option == 3) {
                executeOption3();

            } else if (option == 4) {
                executeOption4();

            } else if (option == 5) {
                executeOption5();

            } else if (option == 6) {
                executeOption6();
            } else if (option == 7) {
                executeOption7();

            } else if (option == 8) {
                executeOption8();
            }

            prettyPrint();
            option = Integer.parseInt(sc.nextLine());
        }
    }

    public static void prettyPrint() {
        System.out.println("Options: \n1.create nodes.\r\n" +
                "2.Add dependency.\r\n" +
                "3.Get children\r\n" +
                "4.Get parents\r\n" +
                "5.Get ancestors\r\n" +
                "6.Get descendants\r\n" +
                "7.Delete Dependency\r\n" +
                "8.Delete Nodes\r\n" +
                "9.Exit\r\n");
    }

    public static void executeOption8() {
        Node node = new Node();
        System.out.println("Enter the node id:");
        Integer id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    node = nodes[i];
                    break;
                }
            }
        }
        node.deleteNode();
        nodes[i] = null;
    }

    public static void executeOption7() {
        Node parent = new Node();
        Node child = new Node();
        System.out.println("Enter the parent node id:");
        Integer id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    parent = nodes[i];
                }
            }
        }
        System.out.println("Enter the child node id:");
        id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    child = nodes[i];
                }
            }
        }
        parent.deleteDependency(child);
    }

    public static void executeOption6() {
        List<Node> descendants;
        Node parent = new Node();
        System.out.println("Enter the node id:");
        Integer id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    parent = nodes[i];
                }
            }
        }
        descendants = parent.getdescendants();
        for (Node j : descendants) {
            System.out.println(j.NodeId);
        }
    }

    public static void executeOption5() {
        List<Node> ancestors;
        Node child = new Node();
        System.out.println("Enter the node id:");
        Integer id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    child = nodes[i];
                }
            }
        }
        ancestors = child.getancestors();
        for (Node j : ancestors) {
            System.out.println(j.NodeId);
        }
    }

    public static void executeOption4() {
        List<Node> parent;
        Node child = new Node();
        System.out.println("Enter the child node id:");
        Integer id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    child = nodes[i];
                }
            }
        }
        parent = child.getparent();
        for (Node j : parent) {
            System.out.println(j.NodeId);
        }
    }

    public static void executeOption3() {
        List<Node> children;
        Node parent = new Node();
        System.out.println("Enter the parent node id:");
        Integer id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    parent = nodes[i];
                }
            }
        }
        children = parent.getchildren();
        for (Node j : children) {
            System.out.println(j.NodeId);
        }
    }

    public static void executeOption2() {
        Node parent = new Node();
        Node child = new Node();
        System.out.println("Enter the parent node id:");
        Integer id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    parent = nodes[i];
                }
            }
        }
        System.out.println("Enter the child node id:");
        id = Integer.parseInt(sc.nextLine());
        for (i = 0; i < count; i++) {
            if (nodes[i] != null) {
                if (nodes[i].NodeId.equals(id)) {
                    child = nodes[i];
                }
            }
        }
        parent.AddDependency(child);
    }

    public static void executeOption1() {
        HashMap<String, String> hmap = new HashMap<String, String>();
        nodes[count] = new Node();
        System.out.println("Enter node name:");
        String name = sc.nextLine();
        System.out.println("Enter number of Additional info:");
        int len = Integer.parseInt(sc.nextLine());
        for (i = 0; i < len; i++) {
            System.out.println("Enter key:");
            String key = sc.nextLine();
            System.out.println("Enter value:");
            String value = sc.nextLine();
            hmap.put(key, value);
        }
        nodes[count].Nodecreate(name, hmap);
        count++;
    }
}
