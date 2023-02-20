class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<Integer> blankIndices = new LinkedList<>();
        Trie trie = new Trie();

        for (int i=0; i<words.length; i++) {
            String word = words[i];

            if (word.equals("")) {
                blankIndices.add(i);
                continue;
            }

            trie.insert(word, i);
        }

        List<List<Integer>> result = new LinkedList<>();

        for (int i=0; i<words.length; i++) {
            String word = words[i];

            if (isPalindrome(word)) {
                for (int blankIdx : blankIndices) {
                    if (blankIdx != i) {
                        result.add(Arrays.asList(i, blankIdx));
                    }
                }
            }

            List<Integer> palindromeIdices = trie.getPalindromeIdices(word);

            for (int idx : palindromeIdices) {
                if (idx != i) {
                    result.add(Arrays.asList(i, idx));
                }
            }
        }

        return result;
    }

    boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) return false;
            start += 1;
            end -= 1;
        }

        return true;
    }

    class Trie {
        Node root = new Node();

        //non reversed word in param
        void insert(String word, int wordIdx) {
            Node tmp = root;

            for (int i=word.length()-1; i>=0; i--) {
                int ch = word.charAt(i) - 'a';
                if (tmp.children[ch] == null) {
                    tmp.children[ch] = new Node();
                }
                tmp = tmp.children[ch];
            }

            tmp.wordIdx = wordIdx;
        }

        List<Integer> getPalindromeIdices(String word) {
            List<Integer> palindromeIdices = new LinkedList<>();

            Node tmp = root;

            for (int i=0; i<word.length(); i++) {
                if (tmp.wordIdx != -1 && isPalindrome(word.substring(i))) {
                    palindromeIdices.add(tmp.wordIdx);
                }
                int ch = word.charAt(i) - 'a';
                if (tmp.children[ch] == null) {
                    return palindromeIdices;
                }
                tmp = tmp.children[ch];
            }
            if (tmp.wordIdx != -1) {
                palindromeIdices.add(tmp.wordIdx);
            }
            //except tmp
            getPalindromeIdices(tmp, "", palindromeIdices, false);

            return palindromeIdices;
        }

        private void getPalindromeIdices(Node tmp, String str, List<Integer> result, boolean isNotFirst) {
            if (isNotFirst && tmp.wordIdx != -1 && isPalindrome(str)) {
                result.add(tmp.wordIdx);
            }

            for (char c='a'; c<='z'; c++) {
                Node child = tmp.children[c - 'a'];
                if (child != null) {
                    getPalindromeIdices(child, str+c, result, true);
                }
            }
        }

        static class Node {
            int wordIdx = -1;
            Node[] children = new Node[26];
        }
    }
}
