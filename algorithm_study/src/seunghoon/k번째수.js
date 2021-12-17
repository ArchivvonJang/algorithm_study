function solution1(array, commands) {
    var answer = [];
    commands.forEach(command => {
        const tempArray = array
						.slice(command[0] -1, command[1])
						.sort((a,b)=> a - b);
        answer.push(tempArray[command[2] -1]);
    })
    return answer;
}
//문제 풀이 1번 slice와 array push 이용

function solution2(array, commands) {
    return commands.map((command) => {
        const [startPosition, endPosition, position] = command;
        const tempArray = array
            .filter((value, index) => index >= startPosition - 1 && index < endPosition)
            .sort((a,b) => a - b);
        return tempArray[position-1];
    })
}
//문제 풀이 2번 다른 사람의 코드를 보고 map과 filter을 이용 구조 분할로 구현
