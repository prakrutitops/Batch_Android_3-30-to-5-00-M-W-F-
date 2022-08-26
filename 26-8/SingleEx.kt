open class A
{
    fun a()
    {
        println("a detail accessed")
    }
}
open class B :A()
{
    fun b()
    {

        println("b detail accessed")

    }
}
class C :B()
{
    fun c()
    {
        println("c detail accessed")
    }
}
fun main()
{
    var c=C()
    c.a()
    c.b()
    c.c()
}