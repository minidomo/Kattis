# KattisTableGenerator
[Download](https://github.com/MiniDomo/Kattis/releases/tag/Kattis-Table-Generator-v2.0.0) (Cross-platform)
### v2.0.0 Upgrade
[v1.0.0](https://github.com/MiniDomo/Kattis/tree/v1.0.0/KattisTableGenerator) was a start to a great program. It allowed for people have a table that would show all the problems they solved on [Kattis](https://open.kattis.com/). However, it wasn't good enough; it was slow, inefficient, and limited to only Windows users. With v2.0.0, I'm finally making this cross-platform and also bringing incredible performance boosts. v1.0.0 was made with [Unity](https://unity3d.com/), but v2.0.0 is made with [.NET Core 2.1](https://dotnet.microsoft.com/download), which is what allows this program to be cross-platform so make sure to download .NET Core 2.1 or higher and add it to your system path. This was coded in [Visual Studio Community 2017](https://visualstudio.microsoft.com/).

### Instructions
Once you downloaded, installed, and added .NET Core 2.1 or higher to your system path and unzipped the .zip file, you can start setting up the program. If any issues are found or clarifications are needed, send an [issue](https://github.com/MiniDomo/Kattis/issues).  
To run the main program:
```
dotnet KattisTableGenerator.dll
```  
If you do not have `KattisIDNameMapping.txt` or want to update it and then run the main program:
```
dotnet KattisMapGenerator.dll
dotnet KattisTableGenerator.dll
```
- `KattisTableGenerator.dll` - This is the main `.dll` that will be ran to generate the `README.md` and `Log.txt`.  
Command prompt usage: `dotnet KattisTableGenerator.dll` 
- `KattisMapGenerator.dll` - This is the other `.dll` that will create a `KattisIDNameMapping.txt` file to substantially increase the performance of the main program.  
Command prompt usage: `dotnet KattisMapGenerator.dll`  
- `KattisIDNameMapping.txt` - This holds the IDs and corresponding names of all the Kattis problems up to the date of when you last ran `KattisMapGenerator.dll`. In the .zip, I already included a `KattisIDNameMapping.txt` with the list of IDs and names of available on Kattis as of December 30, 2018. You may need to run `KattisMapGenerator.dll` later in the future to support new problems added to Kattis.  
- `Log.txt` - This is not included intially, however it is created once KattisTableGenerator.dll is ran. This shows some details of what was going while the program was running.  
- `Config.txt` - This is where you will put in the details of what you want your program to do. I left an `ExampleConfig.txt` in case you wanted to see how to use it, but I will also cover it here.  
Actions/Commands for `Config.txt` - Everything must be on individual lines.
    - `IGNORE` - This will prevent certain files from being added to the final `README.md`.  
In the example below, `.java` and `.py` will ignore any file with a `.java` or `.py` extension and prevent it from being added to the `README.md`. `abc.cpp` and `acm.cs` means that those **exact** files will not be added. `hello` means that the kattis problem with ID `hello` will not be added no matter what extension it may have, so, for example, `hello.java` and `hello.c` will not be added. These are the only ways to use `IGNORE`. Note that, it's not needed to ignore extensions that are not support by Kattis. The program is designed to already ignore those extensions. To see which extensions are supported by Kattis, check [Extensions.cs](https://github.com/MiniDomo/Kattis/blob/master/KattisTableGenerator/KattisTableGenerator/KattisTableGenerator/Extensions.cs).
        ```
        IGNORE
        .java
        .py
        abc.cpp
        acm.cs
        hello
        ```
    - `URL` - This tells the program that there may be incoming URLs to be added to process data.  
To use `URL` all you must do is specify the URLs you want to get the files from, and in the final `README.md`, the solutions found in the URLs will link back to its corresponding URL.
        ```
        URL
        https://github.com/MiniDomo/Kattis/tree/master/Java
        https://github.com/MiniDomo/Kattis/tree/master/C%2B%2B
        ```
    - `FOLDER` - This tells that program that there may be incoming folder directories to be added to process data.  
        - `TO:(directory)` - This is a sub-action/command of folder where you **must** use if you want to add files via folders to allow the solutions in the final `README.md` to link back with a solution uploaded onto github.  

        In the example below, `TO:https://github.com/MiniDomo/Kattis/tree/master/C%2B%2B` means that in the upcoming directories, the valid kattis solutions will link back to `https://github.com/MiniDomo/Kattis/tree/master/C%2B%2B`. For example, let's say in `C:\Users\domob\Documents\Kattis\C++ Solutions`, I had a solution called `acm.cpp`. In the `README.md` it will be printed as `[C++](https://github.com/MiniDomo/Kattis/blob/master/C%2B%2B/acm.cpp)`. This is correct assuming you actually upload `acm.cpp` to `https://github.com/MiniDomo/Kattis/tree/master/C%2B%2B`. In addition, all files below the `TO:(directory)` will link back with the latest `TO:(directory)` used, so `C:\Users\domob\Documents\Kattis\C# Solutions` and
        `C:\Users\domob\Documents\Kattis\Java Solutions` will link with `https://github.com/MiniDomo/Kattis/tree/master/C%23`.
        ```
        FOLDER
        TO:https://github.com/MiniDomo/Kattis/tree/master/C%2B%2B
        C:\Users\domob\Documents\Kattis\C++ Solutions
        TO:https://github.com/MiniDomo/Kattis/tree/master/C%23
        C:\Users\domob\Documents\Kattis\C# Solutions
        C:\Users\domob\Documents\Kattis\Java Solutions
        ```
    Mix Example  
    ```
    
    FOLDER
    TO:https://github.com/MiniDomo/Kattis/tree/master/C%2B%2B
    C:\Users\domob\Documents\Kattis\C++ Solutions

    TO:https://github.com/MiniDomo/Kattis/tree/master/C%23
    C:\Users\domob\Documents\Kattis\C# Solutions
    C:\Users\domob\Documents\Kattis\Java Solutions

    IGNORE
    2048

    abc.java
    .cpp

    parking.cs



    URL
    https://github.com/MiniDomo/Kattis/tree/master/C%2B%2B


    https://github.com/MiniDomo/Kattis/tree/master/C%23
    ```
    As you can see, blank lines do not matter, and order of actions/commands do not matter. However, the first non-blank line must be an action.  
    "Bad" Example - This will result in an error.
    ```
    diufhiodfh

    URL
    https://github.com/MiniDomo/Kattis/tree/master/C%23
    ```