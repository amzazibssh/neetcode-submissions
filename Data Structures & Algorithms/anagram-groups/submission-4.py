class Solution:
    
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        signatures = {}
        result = []
        for word in strs: 
            word_signature = tuple(self.signature(word))
            if word_signature in signatures:
                signatures[word_signature].append(word)
            else:
                signatures[word_signature] = [word]
        
        for key,value in signatures.items():
            result.append(value)

        return result

    def signature(self, word: str) -> List[int]:
        count = [0] * 26

        for c in word:
            count[ord(c) - ord('a')] += 1
        return count