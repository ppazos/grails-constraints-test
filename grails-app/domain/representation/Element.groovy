package representation

class Element extends Item {

    String value

    static constraints = {
        value(maxSize:1024)
    }
}
