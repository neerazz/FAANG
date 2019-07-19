//Top level Functions - Without class
//Main without arguments
fun main() {
    val name = "Sachi";
    println("Hello $name");
}

fun coolName(){
    println("This sis from fun")
}

//Main with Arguments
//Array is a class
fun main(args: Array<String>) {
    val name = "Two";
    //if is an expression
    val arg = if (args.isNotEmpty()) args[0] else "myArg"
    //Using variables - $val
    println("Hello $name and $arg");
    //Calling functions - ${}
    println("Function - ${coolName()}")
}