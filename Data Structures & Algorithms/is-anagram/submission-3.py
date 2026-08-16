class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        import string
        if len(s) != len(t):
            return False
        
        alpha = {char: 0 for char in string.ascii_lowercase}

        for c in s:
            alpha[c] = alpha[c] + 1
        for c in t: 
            alpha[c] = alpha[c] - 1
        for key, value in alpha.items():
            if value != 0:
                return False
        return True                