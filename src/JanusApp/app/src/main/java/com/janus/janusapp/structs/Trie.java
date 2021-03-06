package com.janus.janusapp.structs;

import java.util.Arrays;

public class Trie<T> {

    public LinkedL<TrieNode<T>> letters;

    public Trie() {
        letters = new LinkedL<TrieNode<T>>();
    }

    public void addWord(String newWord, T newObject) {
        Node<TrieNode<T>> current = letters.Firstnode;
        LinkedL<TrieNode<T>> currentList = this.letters;
        int i = 0;
        do {
            char newLetter = newWord.charAt(i);
            TrieNode<T> newTrieNode = new TrieNode<T>(newLetter);
            if (currentList.isEmpty()) {
                if (i == newWord.length() - 1) {
                    newTrieNode.inObject = newObject;
                }
                currentList.append(newTrieNode);
                currentList = newTrieNode.childs;
                i++;
            } else {
                if (i == newWord.length() - 1) {
                    newTrieNode.inObject = newObject;
                }
                if (current.next != null) {
                    if (current.data.letter != newLetter) {
                        current = current.next;
                    } else {
                        currentList = current.data.childs;
                        current = current.data.childs.Firstnode;
                        i++;
                    }
                } else {
                    if (current.data.letter != newLetter) {
                        //posible error
                        currentList.append(newTrieNode);
                        current = currentList.Lastnode;
                        currentList = current.data.childs;
                    } else {
                        currentList = current.data.childs;
                        current = current.data.childs.Firstnode;
                    }
                    i++;
                }
            }
        } while (i < newWord.length());
    }

    public T findWord(String wordToFind) {
        Node<TrieNode<T>> current = letters.Firstnode;
        int i = 0;
        do {
            char newLetter = wordToFind.charAt(i);
            if (current != null && current.data != null) {
                if (current.data.letter == newLetter) {
                    if (current.data.inObject != null) {
                        if (i == wordToFind.length() - 1) {
                            return current.data.inObject;
                        } else {
                            current = current.data.childs.Firstnode;
                            i++;
                        }
                    } else {
                        if (i == wordToFind.length() - 1) {
                            return current.data.inObject;
                        } else {
                            current = current.data.childs.Firstnode;
                            i++;
                        }
                    }
                } else {
                    current = current.next;
                }
            } else {
                break;
            }
        } while (i < wordToFind.length());
        return null;
    }

    public Object[] findSuggestions(String string){

        DynamicArray<String> suggestions = new DynamicArray<String>();
        Node<TrieNode<T>> current = this.letters.Firstnode;
        LinkedL<TrieNode<T>> currentList;
        int i = 0;
        do{
            if (current==null){
                return null;
            }
            if(string.charAt(i)==current.data.letter){
                currentList = current.data.childs;
                if(i<string.length()-1){
                    current = currentList.Firstnode;
                }
                i++;
            }else{
                current = current.next;
            }

        }while(i<string.length());
        if(!current.equals(this.letters.Firstnode)){
            suggestions = current.data.findValidChilds(suggestions);
        }
        return  Arrays.copyOfRange(suggestions.array,0,suggestions.size);
    }

}