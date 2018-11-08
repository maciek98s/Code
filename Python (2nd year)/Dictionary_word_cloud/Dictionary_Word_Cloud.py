#Program to read text from a file and put into html code using dictionaries
#Author : Maciej skrzypczynski
fo = open("output.html", "w")
fo.write('<!DOCTYPE html>\
    #<html>\
    #<head lang="en">\
    #<meta charset="UTF-8">\
    #<title>Tag Cloud Generator</title>\
    #</head>\
    #<body>\
    #<div style="text-align: center; vertical-align: middle; font-family: arial; color: red; background-color:white; border:1px solid black">')

import string
x=5
count_dict = {}
file = open("gittysburg.txt","r")
line = file.read()
line = line.lower()

bad_char = string.punctuation

for i in bad_char:
    line = line.replace(i, '')
line = line.split()

for word in line:
    if word in count_dict:
        count_dict[word]+=1
    else:
        count_dict[word]=1

for key,value in count_dict.items():
    fo.write('<span style="font-size: {}px"> {} </span>'.format(value *10,key))

fo.write('</div>\
    </body>\
    </html>')
fo.close()
file.close()