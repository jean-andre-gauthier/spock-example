/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification

class CodenarcSpec extends Specification {
    def "boolean in then - working as expected"() {
        when:
        println("when")

        then:
        false
    }

    def "boolean in expect - working as expected"() {
        expect:
        false
    }

    def "if in then - not working as expected"() {
        when:
        println("when")

        then:
        if (true) {
          false
        }
    }

    def "if in expect - not working as expected"() {
        expect:
        if (true) {
            false
        }
    }

    def "for in then - not working as expected"() {
        when:
        println("when")

        then:
        for (var i= 0; i < 10; i++) {
            i != 9
        }
    }

    def "lambda in then - not working as expected"() {
        when:
        println("when")

        then:
        [1, 2, 3].map()
    }

    def "if in with in then - working as expected"() {
        when:
        println("when")

        then:
        with(new Object()) {
            if (true) {
                false
            }
        }
    }

    def "for in with in then - working as expected"() {
        when:
        println("when")

        then:
        with(new Object()) {
            for (var i= 0; i < 10; i++) {
                i != 9
            }
        }
    }

    def "if in with in expect - working as expected"() {
        expect:
        with(new Object()) {
            if (true) {
                false
            }
        }
    }

    def "for in with in expect - working as expected"() {
        expect:
        with(new Object()) {
            for (var i= 0; i < 10; i++) {
                i != 9
            }
        }
    }

    def "boolean in given - not working as expected"() {
        given:
        false

        expect:
        true
    }

    def "assert boolean in given - working as expected"() {
        given:
        assert false

        expect:
        true
    }

    def "boolean in cleanup - not working as expected"() {
        expect:
        println("expect")

        cleanup:
        false
    }

    def "assert in cleanup - working as expected"() {
        expect:
        println("expect")

        cleanup:
        assert false
    }

    def "boolean in helper method - not working as expected"() {
        expect:
        myHelperMethod()
    }

    void myHelperMethod() {
        false
        true
    }

    def "boolean in void helper method - not working as expected"() {
        expect:
        myHelperMethodWithoutAssert()
    }

    void myHelperMethodWithoutAssert() {
        false
    }

    def "assert boolean in void helper method - working as expected"() {
        expect:
        myHelperMethodWithAssert()
    }

    void myHelperMethodWithAssert() {
        assert false
    }

    def "boolean in block statement - working as expected"() {
        expect:
        {
            false
        }
    }
}
