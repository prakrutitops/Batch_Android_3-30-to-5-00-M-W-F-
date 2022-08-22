fun main()
{
    println("Enter your name")
    var name= readLine()

    println("Enter your id")
    var id= readLine()!!.toInt()

    println("Enter your salary")
    var salary= readLine()!!.toDouble()

    println("Your Name is $name")
    println("Your ID is $id")
    println("Your Salary is $salary")
}