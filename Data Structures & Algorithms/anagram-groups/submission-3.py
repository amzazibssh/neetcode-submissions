class Solution:
    
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sorted_words = {}
        result = []
        for word in strs: 
            sorted_word = tuple(sorted(word))
            if sorted_word in sorted_words:
                sorted_words[sorted_word].append(word)
            else:
                sorted_words[sorted_word] = [word]
        
        for key,value in sorted_words.items():
            result.append(value)

        return result