# Yelp Data Analysis


### Introduction

This project tries to find the reasons behind bad reviews for restaurants having multiple reviews withh less than 2 stars

### Approach
- Reviews having less than 3 stars made for restaurants were filtered out
- A tokenizing function is used to remove stop words
- A SVM classifier was built to classify the sentences in a review as relevant and non-relevant
- A logistic Regression classifier was built to do Part of Speach tagging of the relevant sentences
- The relevant sentences are grouped according to business ID and then most frequently used nouns are found out.
- These nouns are assumed to be addressed in the review.
- The adjectives following that noun(subject) usually gives a better insight about the noun
- This adjective combined with noun is considered as the reason behind the bad reviews

### Sample Output

Restaurant Name: Emeril’s New Orleans Fish House
Collecting Significant Negative Reviews for the Restaurant
Analyzing the negative reviews
Most Frequent Subjects in negative Reviews
[('food', 173), ('service', 148), ('restaurant', 120), ('emeril', 102), ('shrimp', 65)]
Extracting comments about the most frequent subjects
food
-----
['poor', 'expensive', 'disappointing', 'cold', 'confused', 'unusual', 'alarming', 'worse', 'poor', 'wasted', 'bad', 'poor']
service
-----
['poor', 'lacking', 'odd', 'poor', 'slow', 'questionable', 'bad', 'slow', 'strange', 'lacking', 'odd', 'inexcusable', 'worst', 'bad', 'dead']
restaurant
-----
['poor', 'poor', 'bad', 'joke', 'disappointed', 'dead']
emeril
-----
['awful', 'disappointed', 'sink']
shrimp
-----
['worst', 'cold', 'dead']


### Experiment

- 5 random restaurants and the algorithm was been applied
- Degree of worseness for each common subject was calculated 
- Degree of worseness = (Number of times the subject is mentioned) / (Number of negative reviews)
- This gave the degree of worsness for food and service
{
'food':
{"Roland's Seafood Grill": 0.9186991869918699,
'Rhythm Kitchen': 1.036231884057971,
'Cracker Barrel Old Country Store': 1.7891566265060241,
"Emeril's New Orleans Fish House": 0.9153439153439153,
'StripSteak': 0.7379310344827587},
'service':
{"Roland's Seafood Grill": 0.5853658536585366,
'Rhythm Kitchen': 0.7391304347826086,
'Cracker Barrel Old Country Store': 0.5240963855421686,
"Emeril's New Orleans Fish House": 0.783068783068783,
'StripSteak': 0.6137931034482759}
}