function permutation(arr, value, result) {
  if (arr.length === 0) {
      return;
  }

  arr.forEach((v, idx, arr) => {
    result.push(value + v);
    const restArr = arr.filter((_, index) => index !== idx);
    permutation(restArr,value + v,result) ;
  });
}

function isPrime(num) {
    if(num <= 1) {
        return false;
    }
    
    if( num % 2 === 0) {
        return num === 2 ? true : false;
    }
    
    if( num === 3, num === 5, num === 7) {
        return true;
    }
    
    const sqrt = parseInt(Math.sqrt(num));
    
    for (let i = 3; i <= sqrt; i += 2) {
        if(num % i === 0){
            return false;
        }
    }
    
    return true;
}

function solution(numbers) {
    var numberList = numbers.split('');
    var combinationList = [];
    permutation(numberList, '' , combinationList);
   return combinationList.map(v=>Number(v)).filter((item,index,arr) => arr.indexOf(item) == index).filter(v=> isPrime(v)).length;
}
