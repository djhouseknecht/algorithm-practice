### Scope
> where to look for things
- What are we looking for? Variables
- Who is doing the looking? 

JavaScript has function scope only*

```javascript 
var foo = "bar";

function bar() {
	var foo = "baz";
}

function baz() { 
	foo = "bam";
	bam = "yay";
}
```

LHS = left hand side
RHS = right hand side 

of an assignment. 

For the line `bam = "yay";`, because we are not in `strict` mode, it will create a `bam` variable in the _**global**_ scope. If we had been in `strict` mode, we would have gotten an error because `bam` is **undeclared**.


```javascript
var foo = "bar";

function bar() { 
	var foo = "baz";

	function baz(foo) { 
		foo = "bam";
		bam = "yay"; // this creates a global var bam
	}
	baz();
}

bar();
foo;		// "bar"
bam;		// "yay"
baz();	// Error! 
// The compiler will NOT create a global function even in non-strict mode
```

assigning a variable to a function expression: 
```javascript
var foo = function bar() { 
	var foo = "baz";
	// you could call bar(); here because it is in scope

	function baz(foo) { 
		foo = bar;
		foo; 		// function...
	}
	baz();
};

foo();
bar();		// Error! 
// Because the function was assigned to foo in the global scope
// bar() is in 1-9's scope
```

`catch` arguments are always block scope. 
```javascript
try { 
	foo.length;
}
catch (err) { 
	// catch argument variables are always block scope 
	console.log(err); // TypeError
}

console.log(err); // ReferenceError
```

## Scoping Models 

### Lexical Scope
Compile time scope. 

### Dynamic scope
??? 

Ways to cheat lexical scope: 
```javascript
var bar = "bar";

function foo(str) { 
	eval(str); // cheating. Don't do this
	console.log(bar); // 42
}

foo("var var = 42;");
```


