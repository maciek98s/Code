
#!/bin/sh

echo Enter File to be found 
read a

if test -f $a
then
echo file is found
else
echo file is not found  
fi
