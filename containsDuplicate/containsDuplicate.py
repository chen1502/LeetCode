class Solution:
    # @param {integer[]} nums
    # @return {boolean}
    def containsDuplicate(self, nums):
        appeared = set()
        for n in nums:
            if n in appeared:
                return True
            appeared.add(n)
        return False
