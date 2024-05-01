package coding.challenge3.huffmanCompression;

import java.io.*;
import java.net.URL;
import java.util.*;

public class HuffmanCompression {
   Map<Character,String> huffmanEncodingCharacterMap = new HashMap<>();
    Map<String,Character> huffmanCodingKeysMap = new HashMap<>();
    public static void main(String args[]) {
        HuffmanCompression huffmanCompression = new HuffmanCompression();
        try {
            URL sourceFilePath = HuffmanCompression.class.getClassLoader().getResource("Compression.txt");
            String textToCompress = huffmanCompression.readFromText(sourceFilePath.getPath());
            List<Map.Entry<Character, Integer>> listOfEntries = huffmanCompression.doCharactersCount(textToCompress);
            SearchTrie searchTrie = null;
            HuffmanBaseNode tree =  huffmanCompression.buildSearchTries(listOfEntries);
            huffmanCompression.printCode(tree,"");
            huffmanCompression.writeToFile( textToCompress);
            huffmanCompression.decompress(tree);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    String readFromText(String filePath) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader file = new FileReader(filePath);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            stringBuilder.append(sc.nextLine());
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }

    List<Map.Entry<Character, Integer>> doCharactersCount(String text) {
        Map<Character, Integer> characterCountMap= new HashMap<>();
        for(Character c: text.toCharArray()) {
            if(characterCountMap.containsKey(c)) {
                characterCountMap.put(c, characterCountMap.get(c)+1);
                continue;
            }
            characterCountMap.put(c,1);
        }

        List<Map.Entry<Character, Integer>> listOfEntries = new ArrayList<>(characterCountMap.entrySet());
        listOfEntries.sort(new SortMapByValueDescending());
        return listOfEntries;
    }

    HuffmanBaseNode buildSearchTries(List<Map.Entry<Character, Integer>> listOfEntries) {
        PriorityQueue<HuffmanBaseNode> priorityQueue = new PriorityQueue<>(new Comparator<HuffmanBaseNode>() {
            @Override
            public int compare(HuffmanBaseNode o1, HuffmanBaseNode o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });

        for(Map.Entry<Character,Integer> entry: listOfEntries) {
            priorityQueue.add(new HuffmanLeafNode(entry.getKey(), entry.getValue()));
        }

        while(priorityQueue.size() > 1) {
            HuffmanBaseNode a=  priorityQueue.poll();
            HuffmanBaseNode b=  priorityQueue.poll();
            int weight = a.getWeight()+b.getWeight();
            HuffmanBaseNode node = new HuffmanTreeNode(weight, a,b);
            priorityQueue.add(node);
        }
        return priorityQueue.poll();
    }

    void printCode(HuffmanBaseNode tree, String s) {
        if(tree.isLeaf()) {
            HuffmanLeafNode leafNode = (HuffmanLeafNode) tree;
            huffmanEncodingCharacterMap.put(leafNode.getElement(),s);
            System.out.println(leafNode.getElement() +":"+ s);
            huffmanCodingKeysMap.put(s, ((HuffmanLeafNode) tree).getElement());
            return;
        }
        HuffmanTreeNode node = (HuffmanTreeNode) tree;
        printCode(node.getLeftLeafNode(),s+"0");
        printCode(node.getRightLeafNode(),s+"1");
    }

    private static class SortMapByValueDescending implements Comparator<Map.Entry<Character, Integer>> {

        @Override
        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
           return o1.getValue().compareTo(o2.getValue());
        }
    }

    void writeToFile(String textToCompress) {
        try {
            File file = new File("src/main/resources/Encoding-Compressed.txt");
            if(file.createNewFile()) {
                System.out.println("New file created:" +file.getName());
            }
            FileWriter fileWriter = new FileWriter(file);
//            fileWriter.write("------------------ HUFFMAN ENCODING --------------------------\n");
            for(char c: textToCompress.toCharArray()) {
                fileWriter.write(String.valueOf(huffmanEncodingCharacterMap.get(c)));
            }

//            fileWriter.write("\n------------------ END OF FILE --------------------------\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void decompress(HuffmanBaseNode tree) {
        try {
            String encodedText = readFromText("src/main/resources/Encoding-Compressed.txt");
            File file = new File("src/main/resources/Encoding"+"-"+"Decompressed");
            if(file.createNewFile()) {
                System.out.println("New file created:" +file.getName());
            }
            FileWriter fileWriter = new FileWriter(file);
            StringBuilder s = new StringBuilder();
            HuffmanBaseNode node =  tree;
            for(int i =0;i<encodedText.length();i++) {
                if(node.isLeaf()) {
                    s.append(((HuffmanLeafNode) node).getElement());
                    node = tree;
                }
                node = encodedText.charAt(i) == '1' ? ((HuffmanTreeNode) node).getRightLeafNode() : ((HuffmanTreeNode) node).getLeftLeafNode();

            }
            fileWriter.write(s.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


