-- day05_select_groupby.sql

-- GROUP BY 절 ------------------------------------------------------------------------------------
-- 같은 값들이 여러 개 기록된 컬럼을 가지고 같은 값들을 그룹으로 묶어줌
-- GROUP BY 컬럼명 | 컬럼이 사용된 계산식
-- 같은 값들을 그룹으로 묶어서 그룹함수를 사용함.
-- SELECT 절에 GROUP BY 로 묶은 그룹별 그룹함수 사용 구문을 작성함.

-- 컬럼에 기록된 값 확인
SELECT DISTINCT DEPT_ID
FROM EMPLOYEE
ORDER BY 1; -- 7행

SELECT EMP_ID, DEPT_ID
FROM EMPLOYEE
ORDER BY DEPT_ID;

-- 부서별 급여의 합계 조회
SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY 1 DESC NULLS LAST;

SELECT DEPT_ID,
           SUM(SALARY) 부서별급여합계,
           FLOOR(AVG(SALARY)) 부서별급여평균,
           COUNT(SALARY) 부서별직원수,
           MAX(SALARY) 부서별급여큰값,
           MIN(SALARY) 부서별급여작은값
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY 1 ASC NULLS LAST;

-- GROUP BY 절에는 그룹으로 묶기 위한 계산식을 사용할 수도 있음
-- 직원 정보에서 성별별 급여 합계, 급여 평균(천단위에서 반올림함), 직원수 조회
-- 성별로 오름차순정렬함
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '3', '남', '여') 성별,
            SUM(SALARY) 급여합계,
            ROUND(AVG(SALARY), -4) 급여평균,
            COUNT(*) 직원수
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '3', '남', '여')
ORDER BY 성별;

-- GROUP BY 관련 함수 ------------------------------------------------------------------

-- ROLLUP() 함수
-- GROUP BY 절에서만 사용함.
-- 그룹별로 묶어서 계산한 결과에 대한 집계와 총 집계를 표현하는 함수.
-- EXCEL의 부분합과 같음. 소계 처리

-- 확인
SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID;

-- NULL 제외
SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL
GROUP BY DEPT_ID;

-- ROLLUP() 사용
SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID); -- (null) : 총 집계

-- 총 집계 확인
SELECT DEPT_ID,
           SUM(SALARY) 부서별급여합계,
           FLOOR(AVG(SALARY)) 부서별급여평균,
           COUNT(SALARY) 부서별직원수,
           MAX(SALARY) 부서별급여큰값,
           MIN(SALARY) 부서별급여작은값
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID);

-- 연습 : 부서코드와 직급코드를 함께 그룹으로 묶고, 급여의 합계를 구함
-- NULL은 제외함, ROLLUP() 사용
SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY DEPT_ID, JOB_ID
ORDER BY 1 DESC;

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID, JOB_ID)
ORDER BY 1 DESC;

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID), ROLLUP(JOB_ID)
ORDER BY 1 DESC;

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(JOB_ID), ROLLUP(DEPT_ID)
ORDER BY 1 DESC;

-- CUBE() 함수
SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(DEPT_ID, JOB_ID)
ORDER BY 1 DESC;








