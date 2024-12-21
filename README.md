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
|dropwhile|pred, list|list[n], list[n+1], pred가 실패할 때 시작|dropWhile(integer -> (integer < 5),[1,4,6,4,1]) --> 6 4 1|
|filterfalse|pred, list|pred(elem)이 거짓인 list의 요소들|filterFalse(integer -> (integer % 2 == 0),[0,1,2,3,4,5,6,7,8,9]) --> 0,2,4,6,8|
|groupby|list|연속된 리스트 값 그룹화|groupby("A","A","A","A","B","B","B","C","C","D","B") --> A B C D B|
|islice|list, start, end, step|list의 start 인덱스부터 end 인덱스 전까지 슬라이스|iSlice(["A","B","C","D","E","F","G"],2,4,1) --> C D|
|takewhile|pred, list|list[0], list[1], list가 실패할 때까지|takewhile(integer -> (integer < 5),[1,4,6,4,1]) --> 1 4|
|tee|list, n|list 모든 요소를 음절 단위로 n회 반복 출력|tee(["AB","CDE"],3) --> A B C D E A B C D E A B C D E|
|zip_longest|listA, listB, fillValue|(listA[0]+listB[0]), (listA[1]+listB[1]), … (listA[listA.size()-1]+fillValue)|zip_longest(["A","B","C","D"], ["x","y"], '-') --> Ax By C- D-|
|product|listA, listB|데카르트 곱(cartesian product), 중첩된 for 루프와 동등|product(["A","B","C","D"], ["x","y"]) --> Ax Ay Bx By Cx Cy Dx Dy|
|product|list, repeat|데카르트 곱(cartesian product), 중첩된 for 루프와 동등|product(["A","B","C","D"], 2) --> AA AB AC AD BA BB BC BD CA CB CC CD DA DB DC DD|
|permutations|list, r|r-길이 리스트들, 모든 가능한 순서, 반복되는 요소 없음|permutations(["A","B","C","D"], 2) --> AB AC AD BA BC BD CA CB CD DA DB DC|
|combinations|list, r|r-길이 리스트들, 정렬된 순서, 반복되는 요소 없음|combinations(["A","B","C","D"], 2) --> AB AC AD BC BD CD|
|combinations_with_replacement|list, r|r-길이 리스트들, 정렬된 순서, 반복되는 요소 있음|combinations_with_replacement(["A","B","C","D"], 2) --> AA AB AC AD BB BC BD CC CD DD|

- bisect 라이브러리

|Method|매개변수|반환값|예시|
|------|---|---|---|
|bisect_left|list, x, [low], [high]|정렬된 순서를 유지하도록 list에 x를 삽입할 위치를 찾음, x가 list에 이미 존재 시 기존 항목 앞 인덱스 반환|bisect_left([10, 20, 30, 40, 50, 60, 70, 80, 90, 100],50) --> 4<br>bisect_left([10, 20, 30, 40, 50, 60, 70, 80, 90, 100],0,2,8) --> 2|
|bisect_right|list, x, [low], [high]|정렬된 순서를 유지하도록 list에 x를 삽입할 위치를 찾음, x가 list에 이미 존재 시 기존 항목 뒤 인덱스 반환|bisect_right([10, 20, 30, 40, 50, 60, 70, 80, 90, 100],50) --> 5<br>bisect_right([10, 20, 30, 40, 50, 60, 70, 80, 90, 100],0,2,8) --> 2|
|insort_left|list, x, [low], [high]|정렬된 순서를 유지하도록 list에 x를 삽입한 리스트 반환, x가 list에 이미 존재 시 기존 항목 앞에 추가한 리스트 반환|insort_left([10, 20, 30, 40, 50], 30) --> [10, 20, 30, 30, 40, 50]<br>insort_left([10, 20, 30, 40, 50], 0,1,4) --> [10, 0, 20, 30, 40, 50]|
|insort_right|list, x, [low], [high]|정렬된 순서를 유지하도록 list에 x를 삽입한 리스트 반환, x가 list에 이미 존재 시 기존 항목 뒤에 추가한 리스트 반환|insort_right([10, 20, 30, 40, 50], 30) --> [10, 20, 30, 30, 40, 50]<br>insort_right([10, 20, 30, 40, 50], 100,1,4) --> [10, 20, 30, 40, 100, 50]|

## 설치 방법
### Gralde
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
	implementation 'com.github.InvestLee:Python_library_in_Java:1.1.0'
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
    <version>1.1.0</version>
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
