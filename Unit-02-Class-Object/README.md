# Class & Object
Kotlin has some unique types of class and object.

## Data Class
We often create classes to mainly hold data. We have done it in Java like this:

    public class Animal{
      private int legnum;
      private String sound;
      // Getter
      public int getLegNumber(){
       return legnum;
      }
      public String getSound(){
       return sound;
      }
      // Setter
      public void setLegNumber(int n){
        this.legnum = n;
      }
      public void setSound(String sound){
        this.sound = sound;
      }
    }

While the getter method returns the value of the attribute, the setter assigns the value of a parameter to the attribute.

In Kotlin, it is very simple to make this kind of classes called **Data Class**.

    data class Animal(val legnum: Int, val sound: String)
    
You can also create an instance with it and access its properties.

    val ani = Animal(4, "Moo")
    println("The animal has " + ani.legnum + " legs and sounds " + ani.sound)
    // The animal has 4 legs and sounds Moo
    
Oh, you might be worried about visibility of the properties. Don't worry bro, let's take a look at the decompiled codes for the class. (For Intellij IDEA, go to Tools > Kotlin > Show Kotlin Bytecode, and press the Decompile button.) After you notice these,

  * private final int legnum
  * private final String sound
  * public final int getLegnum()
  * public final String getSound()

you would feel relieved.

(Full Codes: )

    public final class Animal {
       private final int legnum;
       @NotNull
       private final String sound;

       public final int getLegnum() {
          return this.legnum;
       }

       @NotNull
       public final String getSound() {
          return this.sound;
       }

       public Animal(int legnum, @NotNull String sound) {
          Intrinsics.checkNotNullParameter(sound, "sound");
          super();
          this.legnum = legnum;
          this.sound = sound;
       }

       public final int component1() {
          return this.legnum;
       }

       @NotNull
       public final String component2() {
          return this.sound;
       }

       @NotNull
       public final Animal copy(int legnum, @NotNull String sound) {
          Intrinsics.checkNotNullParameter(sound, "sound");
          return new Animal(legnum, sound);
       }

       // $FF: synthetic method
       public static Animal copy$default(Animal var0, int var1, String var2, int var3, Object var4) {
          if ((var3 & 1) != 0) {
             var1 = var0.legnum;
          }

          if ((var3 & 2) != 0) {
             var2 = var0.sound;
          }

          return var0.copy(var1, var2);
       }

       @NotNull
       public String toString() {
          return "Animal(legnum=" + this.legnum + ", sound=" + this.sound + ")";
       }

       public int hashCode() {
          int var10000 = Integer.hashCode(this.legnum) * 31;
          String var10001 = this.sound;
          return var10000 + (var10001 != null ? var10001.hashCode() : 0);
       }

       public boolean equals(@Nullable Object var1) {
          if (this != var1) {
             if (var1 instanceof Animal) {
                Animal var2 = (Animal)var1;
                if (this.legnum == var2.legnum && Intrinsics.areEqual(this.sound, var2.sound)) {
                   return true;
                }
             }

             return false;
          } else {
             return true;
          }
       }
    }

## Backing Field
For data class, Kotlin compiler generates a getter for val property, and both a getter and a setter for var property. Kotlin uses a Java field to store the property values, which is called **backing field**.

Suppose that we create some custom accessors. Let's make a simple getter for *val isNoisy*, and a setter for *var legnum*. You might try to imitate an example from Internet like this...

    data class Animal(val sound: String){
        val isNoisy: Boolean
        get() = (sound.length > 5)
        var legnum: Int = 0
        set(value){
            println("Setter is called.")
                legnum = value
        }
    }

    fun main(){
        val ani = Animal("COCK-A-DOODLE-DOO!")
        ani.legnum = 2
        println("The animal has " + ani.legnum + " legs and sounds " + ani.sound)
        if(ani.isNoisy)
            println("Be careful! It is noisy.")
    }

Good! Almost done but however, it will get into the infinite loop and cause an exception, StackOverflowError. What's wrong with it?

    set(value){
        println("Setter is called.")
            legnum = value
    }
    
You may notice there were too many "Setter is called." prints for your console. Actually, there is a small problem with the setter. It continuously calls *legnum*. When you called the setter for the first time,

    ani.legnum = 2
    
It tried to call *legnum* which makes another call of the setter, and so on. We were trying to set the field inside the setter itself!

    set(value){
        println("Setter is called.")
            field = value
    }
    
Instead of directly calling it, we can use backing field for this property. It is provided by Kotlin automatically, so we can reference it through *field* keyword.
