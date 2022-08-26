class ConstructorEx(var id:Int,var name:String)
{

}

fun main()
{
    var c1 = ConstructorEx(101,"Abcd")
    var c2 = ConstructorEx(102,"Pqrs")

    println("Your id is ${c1.id}  , your name is ${c1.name}")
    println("Your id is ${c2.id}  , your name is ${c2.name}")
}