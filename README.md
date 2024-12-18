파이썬 라이브러리에만 있는 itertools, bisect를 자바에도 구현해보는 오픈 라이브러리입니다.

- itertools 라이브러리
  - count(start, [step])
  - cycle(p)
  - repeat(elem [,n])
  - accumulate(p [,func])
  - chain(p, q, …)
  - compress(data, selectors)
  - dropwhile(pred, seq)
  - filterfalse(pred, seq)
  - groupby(iterable[, key])
  - islice(seq, [start,] stop [, step])
  - takewhile(pred, seq)
  - tee(it, n)
  - zip_longest(p, q, …)
  - product(p, q, … [repeat=1])
  - permutations(p[, r])
  - combinations(p, r)
  - combinations_with_replacement(p, r)
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
