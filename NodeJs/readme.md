- [Quick notes about NodeJS](#quick-notes-about-nodejs)
- [global](#global)
  - [Functions available](#functions-available)
  - [`process` variable](#process-variable)
    - [Getting command line arguments](#getting-command-line-arguments)
  - [setTimeout()](#settimeout)
  - [setInterval() and clearInterval()](#setinterval-and-clearinterval)
- [Node Modules](#node-modules)
  - [Taking user input](#taking-user-input)
  - [TODO : Path Module](#todo--path-module)
  - [Fs Module](#fs-module)
- [Exporting Modules](#exporting-modules)
- [Miscellaneous Things](#miscellaneous-things)
  - [Multiline Strings](#multiline-strings)
  - [Important Videos to Watch](#important-videos-to-watch)

# Quick notes about NodeJS

# global

## Functions available

```js
for (let key in global) {
  console.log(key);
}
```

- global
- queueMicrotask
- clearImmediate
- setImmediate
- structuredClone
- clearInterval
- clearTimeout
- setInterval
- setTimeout
- atob
- btoa
- performance
- fetch
- crypto

## `process` variable

### Getting command line arguments

```js
function getCmdLineArg(flag) {
  const index = process.argv.indexOf(flag) + 1;
  return process.argv[index];
}

console.log("Command line arguments are as follows");
console.log(process.argv);

const brief =
  "This is how the process.argv looks like.\n1. The location where 'node' is stored \n2. The location of the file which is being executed.\nRest are command line arguments\n";
console.log(brief);

console.log(`User = ${getCmdLineArg("--user")}`);
console.log(`Password = ${getCmdLineArg("--password")}`);
```

Execute the program from terminal. The command line arguments should be like

```
--user <username> --password <password>
```

## setTimeout()

- The syntax for this function is `setTimeout(callbackFunction,waitTime)`

```js
const waitTime = 5000; // 5 seconds

console.log("Starting async operation");
setTimeout(() => {
  console.log(`Async operation finished after ${waitTime / 1000} seconds`);
}, waitTime);
```

## setInterval() and clearInterval()

- Used to create a "clock"
- Usage is as follows

```js
const waitInterval = 500; // 0.5 seconds
const waitTime = 5000; // 5 seconds
let currentTime = 0;

// A function which is executed after every "waitInterval" seconds
const incrementTime = () => {
  currentTime += waitInterval;
  console.log(`Time Elapsed : ${currentTime / 1000} s`);
};

// Creating a timer
const interval = setInterval(incrementTime, waitInterval);

setTimeout(() => {
  clearInterval(interval); // Used to clear the timer
  console.log(`Process finished after ${currentTime / 1000} seconds`);
}, waitTime);
```

> Random Suggestion : Use setInterval() to determine the time it takes for an async operation

# Node Modules

## Taking user input

- To take user input, we will use an inbuilt module called `readLine`
- It is setup as follows

```js
const readLine = require("readline");
// Defining from where we need to take input and where to display data
const rl = readLine.Interface({
  input: process.stdin,
  output: process.stdout,
});
```

- Asking only one question

```js
rl.question("How are you?\n", (answer) => {
  console.log(`Your answer is '${answer}'`);
  process.exit(); // To get out of program
});
```

- Asking multiple questions

```js
const questions = ["How are you?", "What are you?", "Why are you?"];

function askQuestions(questions, done) {
  const ans = [];

  const questionAnswered = (answer) => {
    ans.push(answer); // With each "push" operation, length of ans increases
    if (ans.length < questions.length) {
      rl.question(questions[ans.length] + "\n", questionAnswered);
    } else {
      return done(ans);
    }
  };
  // This executes after "ans" is created
  rl.question(questions[0] + "\n", questionAnswered);
}

askQuestions(questions, (answers) => {
  console.log(`The reported answers are ${answers}`);
  process.exit();
});
```

## TODO : Path Module

## Fs Module

- Since documentation is always available and is ever changing, what I am going to do is to write the basic yet fundamental functions which are available in this module
- This is a quick table. To know how to use the function, search it on web
- In this module, almost each function has a sync version and an async/promise based version
  - sync means "blocking functions". It will stop the execution of whole program till that function is executed
  - async/promise means "non blocking functions". They will be executed later after all the sync functions have executed. Highly recommended for operations which take a longer time to execute.
- While reading / writing files, the text encoding which is primarily used is called `UTF-8`. This needs to be specified in `readFile()` function.

| Function     | Usage                               |
| ------------ | ----------------------------------- |
| readFile()   | Used to read a file                 |
| writeFile()  | Used to write to a file             |
| appendFile() | Used to append to a file            |
| readdir()    | Displays files inside a directory   |
| mkdir()      | Creates a directory                 |
| rmdir()      | Used to remove an _empty directory_ |
| rename()     | Used to rename a file               |
| unlink()     | Used to remove a file               |

Some Notes

1. rename() can also be used to move files and folders
2. To remove a directory, it must be empty. To make a program which removes a directory by deleting every file inside it, the general steps are as follows
   1. Read the contents of the required directory using `readdir()`
   2. Delete each file inside it using `unlink()`
   3. Then remove the directory using `rmdir()`

```js
// A program to remove a directory
// NOTE: The folder is called TEMP and has some files.
const path = require("path");
const fs = require("fs");

const folder_name = "TEMP";

// Absolute path of folder is required
// Paths in windows and linux are different. To generate a suitable path, use the "path" module
const folder_path = path.join(__dirname, folder_name);
console.log(folder_path);

// Getting the list of files present inside the folder
// We used an async function because this allows us to detect whether the folder exists or not
fs.readdir(folder_path, (err, files) => {
  if (err) throw new Error("The folder does not exist");
  console.log(files);
  // Removing the files from folder
  for (let file of files) {
    // Absolute path of file is required
    const file_path = path.join(folder_path, file);
    console.log(`Removing ${file_path}`);
    fs.unlinkSync(file_path);
  }
  // Removing the empty folder
  fs.rmdirSync(folder_path);
  console.log("Folder removed successfully");
});
```

# Exporting Modules

- Each javascript file is essentially a module
- Using `module.exports` file, we can make a js file to be used as a module
- In the below program
  - Module file is "temp.js"
  - The file which is using "temp.js" is called "index.js"

```js
// temp.js
const x = (msg) => {
  console.log(msg);
};

function yo(msg) {
  console.log(msg);
}

function sayHello() {
  console.log("hello");
}

module.exports = {
  v1: true, // exporting a variable
  hello: x, // exporting a function with an identifer 'hello'
  yo, // exporting a function.
  sayHello, // exporting a function.
};
```

```js
//index.js
const temp = require("./temp");
console.log(temp.v1); // Using an exported variable
temp.hello("YO"); // Using an exported function with identifier 'hello'
temp.yo("YO"); // Using an exported function
// Importing limited functionality
const { sayHello } = require("./temp");
sayHello();
```

# Miscellaneous Things

## Multiline Strings

- Created using formatted strings
- Example is as follows

```js
const multiLineString = `
-> This is a multiline string
-> Yay this is awesome
-> Now my strings can look..... elegant
`;
console.log(multiLineString);
```

## Important Videos to Watch

- [ ] https://youtu.be/l20MBBFZAmA
- [ ] https://youtu.be/FZOEL5nByYg
- [ ] [NodeJs advanced concepts](https://youtu.be/1usPp_5mkG0)
