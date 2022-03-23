package study;

import java.util.*;

public class KakaoPay4 {
    public static void main(String[] args) {
        int[] ages = {35, 25, 3, 8, 7};
        int[][] wires = {{1, 2, 5}, {2, 1, 5}, {1, 3, 2}, {3, 4, 2}, {3, 5, 20}, {4, 5, 1}};
        int[] result = solution(ages, wires);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] solution(int[] ages, int[][] wires) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        int[] resultArray = new int[ages.length];
        ArrayList<Node> nodeList = new ArrayList<>();
        int days = 0;

        //노드 생성
        for (int i = 0; i < ages.length; i++) {
            Node node = new Node(i, ages[i]);
            nodeList.add(node);
        }

        //노드 연결
        for (int i = 0; i < wires.length; i++) {
            ConnectNode connectNode = new ConnectNode(nodeList.get(wires[i][0] - 1), wires[i][2]);
            nodeList.get(wires[i][1] - 1).AddConnectNode(connectNode);
        }

        while (result.size() < ages.length) {
            days++;
            for (int i = 0; i < ages.length; i++) {
                if (!nodeList.get(i).isAlive(days)) {
                    result.put(nodeList.get(i).nodeNo+1, nodeList.get(i).nodeNo+1);
                }
            }
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            resultArray[i++] = entry.getKey();
        }

        return resultArray;
    }

    public static class ConnectNode {
        private Node node;
        private int wireLength;

        public ConnectNode(Node node, int wireLength) {
            this.node = node;
            this.wireLength = wireLength;
        }
    }

    public static class Node {
        private int nodeNo;
        private int life;
        private boolean isAlive = true;
        private List<ConnectNode> connectNodeList;

        public Node(int nodeNo, int life) {
            this.nodeNo = nodeNo;
            this.life = life;
            this.connectNodeList = new ArrayList<>();
        }

        public void AddConnectNode(ConnectNode connectNode) {
            this.connectNodeList.add(connectNode);
        }

        public boolean isAlive(int days) {
            if (this.isAlive) {
                for (ConnectNode connectNode : this.connectNodeList) {
                    if (connectNode.node.isAlive && life > days) {
                        return true;
                    } else if (connectNode.node.life + connectNode.wireLength > days && life > days) {
                        return true;
                    }
                }
                this.isAlive = false;
            }
            return false;
        }
    }

}


