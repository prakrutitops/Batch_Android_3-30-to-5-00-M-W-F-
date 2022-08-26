class Student
{
    var id=0
    var name = ""
    var city = ""

    fun detail()
    {
        println("Your id is $id")
        println("Your name is $name")
        println("Your City is $city")
    }
}

fun main(args: Array<String>)
{

    var s = Student()
  /*  s.id=101
    s.name="Hemal"
    s.city="Rajkot"*/

    println("Enter your id")
    var i= readLine()!!.toInt()

    println("Enter your name")
    var n= readLine().toString()

    println("Enter your city")
    var c= readLine().toString()

    s.id=i
    s.name=n
    s.city=c

    s.detail()






}