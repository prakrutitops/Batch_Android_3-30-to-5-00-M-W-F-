fun main()
{
    var a= mutableSetOf<String>("1","2","3","a")

    a.add("a")

    for(element in a)
    {
        println(element)
    }
}