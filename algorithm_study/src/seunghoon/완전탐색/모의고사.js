function solution(answers) {
    const marks = [[1,2,3,4,5],[2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]];
    var count = [0,0,0];
    for (var index in answers) {
        for (var markIndex in marks) {
            if (answers[index] === marks[markIndex][index % marks[markIndex].length]) {
                count[markIndex] = count[markIndex] ? count[markIndex] + 1 : 1;
            }            
        }
    }
    const max = Math.max(...count);
    return count.map((v,i) => v===max ? i+1 : 0).filter(v => v!= 0).sort();
}
