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
bar();
