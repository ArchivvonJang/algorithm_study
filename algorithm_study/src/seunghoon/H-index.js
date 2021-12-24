function solution(citations) {
    var minHindex = 0;
    var sortArray = citations.sort((a,b) => b-a);
    for (var i = 0; i < sortArray.length; i++){
        if (sortArray[i] <= i + 1) {
            return Math.max(sortArray[i], minHindex);
        } else {
            minHindex++;
        }
    }
    return minHindex;
}

//const data = [ 
//  { input: [3, 0, 6, 1, 5], answer: 3 },
//  { input: [0, 0, 0, 0, 0], answer: 0 },
//  { input: [0, 0, 0, 0, 1], answer: 1 },
//  { input: [9, 9, 9, 12], answer: 4 },
//  { input: [9, 7, 6, 2, 1], answer: 3 }, // from Wikipedia
 // { input: [10, 8, 5, 4, 3], answer: 4 }, // from Wikipedia
//  { input: [25, 8, 5, 3, 3], answer: 3 }, // from Wikipedia
//  { input: [1, 1, 5, 7, 6], answer: 3 },
//  { input: [0], answer: 0 },
//  { input: [0, 0], answer: 0 }
//]
