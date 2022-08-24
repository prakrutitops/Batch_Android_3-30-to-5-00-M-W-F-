class MyFirstClass
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }

}
fun MyFirstClass.isScholar(marks: Int):Boolean
{
    return marks>95
}
fun main()
{
    var m = MyFirstClass()
    println("pass status :" + m.hasPassed(96))
    println("sholarship status : " +m.isScholar(96))

}
