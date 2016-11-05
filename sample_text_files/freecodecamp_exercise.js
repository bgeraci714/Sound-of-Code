console.log(    steamrollArray([1, [2], [3, [[4]]]])    );


function steamrollArray(arr) {
    // I'm a steamroller, baby

    var almostThereArr = kamina(arr);

    var thereArr = [];
    for (var i = 0; i < almostThereArr.length; i++)
        if (Array.isArray(almostThereArr[i]))
            thereArr.push(almostThereArr[i]);
        else
            thereArr.push([almostThereArr[i]]);

    var finalArr = thereArr.reduce(function(a,b) {
        return a.concat(b);
    });

    return finalArr;
}


function kamina (arr) {
    var finalForm = [];
    for (var i = 0; i < arr.length; i++) {
        finalForm.push(digDeeperSimon(arr[i]));
    }
    return finalForm;
}

function digDeeperSimon (arr) {
    var temp = [];
    if (!Array.isArray(arr))
        temp = arr;
    else if (arr.length > 1){
        arr.forEach(function(property) {
            //console.log(property);
            temp.push(digDeeperSimon(property));
        });
    }
    else {
        arr.forEach(function(property) {
            //console.log(property);
            temp = digDeeperSimon(property);
        });
    }

    return temp;
}

/*
var almostThereArr = kamina([[[[[[1], 2]],3]],4]).reduce(function(a,b) {
    return a.concat(b);
});

var thereArr = [];
for (var i = 0; i < almostThereArr.length; i++)
    if (Array.isArray(almostThereArr[i]))
        thereArr.push(almostThereArr[i]);
    else
        thereArr.push([almostThereArr[i]]);

console.log(thereArr.reduce(function(a,b) {
    return a.concat(b);
}));
*/
