package representation

class Cluster extends Item{

    static hasMany = [items: Item]

    static constraints = {
    }
}
