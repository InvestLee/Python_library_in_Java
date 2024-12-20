파이썬 라이브러리에만 있는 itertools, bisect를 자바에도 구현해보는 오픈 라이브러리입니다.

- itertools 라이브러리

|Method|매개변수|반환값|예시|
|------|---|---|---|
|count|start, step|start, start+step, start+2*step, …|count(10,1) --> 10 11 12 13 14 ...|
|cycle|list|list.get(0), list.get(1), ... list.get(list.size()-1),list.get(0), list.get(1), ...|cycle(["A","B","C","D"]) --> A B C D A B C D ...|
|repeat|obj, times|obj, obj, obj, .... times만큼 반복|repeat(10, 3) --> 10 10 10|
|accumulatePlus|list, initial|initial, initial + list.get(0), initial + list.get(0) + list.get(1)...|accumulatePlus([1,2,3,4,5], 0) --> 0 1 3 6 10 15|
|accumulateMinus|list, initial|initial, initial - list.get(0), initial - list.get(0) - list.get(1)...|accumulateMinus([1,2,3,4,5], 0) --> 0 -1 -3 -6 -10 -15|
|accumulateMultiply|list, initial|initial, initial * list.get(0), initial * list.get(0) * list.get(1)...|accumulateMultiply([1,2,3,4,5], 1) --> 1 1 2 6 24 120|
|accumulateDivide|list, initial|initial, initial / list.get(0), initial / list.get(0) / list.get(1)...|accumulateDivide([5,4,3,2,1], 120) --> 120 24 6 2 1 1|
|accumulateRemain|list, initial|initial, initial % list.get(0), initial % list.get(0) % list.get(1)...|accumulateRemain([100,10,1], 123) --> 123 23 3 0|
|chain|list|list.get(0).charAt(0), list.get(0).charAt(1) ... list.get(list.size()-1).charAt(list.get(list.size()-1).length()-1) |chain(["ABC", "DEF"]) --> A B C D E F|
|compress|list, selectors|(list[0] if selectors[0]), (list[1] if selectors[1]), …|compress(["A","B","C","D","E","F"], [true,false,true,false,true,true]) --> A C E F|
|dropwhile|pred, seq|Post|/survey/delete|
|filterfalse|pred, seq|Post|/survey/delete|
|groupby|iterable[, key]|Post|/survey/delete|
|islice|seq, [start,] stop [, step]|Post|/survey/delete|
|takewhile|pred, seq|Post|/survey/delete|
|tee|it, n|Post|/survey/delete|
|zip_longest|p, q, …|Post|/survey/delete|
|product|p, q, … [repeat=1]|Post|/survey/delete|
|permutations|p[, r]|Post|/survey/delete|
|combinations|p, r|Post|/survey/delete|
|combinations_with_replacement|p, r|Post|/survey/delete|

- bisect 라이브러리
  - bisect_left(a, x, lo=0, hi=len(a))
  - bisect_right(a, x, lo=0, hi=len(a))
  - insort_left(a, x, lo=0, hi=len(a))
  - insort_right(a, x, lo=0, hi=len(a))

## 설치 방법
### Gralde
```
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	implementation 'com.github.InvestLee:Python_library_in_Java:Tag'
}
```

### Maven
```
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
    <groupId>com.github.InvestLee</groupId>
    <artifactId>Python_library_in_Java</artifactId>
    <version>Tag</version>
</dependency>
```

## License
MIT License

Copyright (c) 2024 InvestLee

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
