fun main()
{
    var a= mutableListOf(1,2,3)

    a.add(4)

    var b= mutableListOf(4,5,6)

   // a.addAll(b)
   // a.removeAt(1)

    a.retainAll(b)

    for(element in a)
    {
        println(element)
    }
}