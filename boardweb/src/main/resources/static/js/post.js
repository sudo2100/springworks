
// 입력값 읽기 함수
function getValue(id){
    return document.getElementById(id).value;
}

// 글 등록 - POST /api/posts, + JSON 데이터
const createButton = document.getElementById('create-btn');
if(createButton){
    createButton.addEventListener('click', () => {
        // 입력값 검증
        if(!getValue('title') || !getValue('writer')
            || !getValue('content')){
            alert("모든 필드를 입력하세요.");
            return;
        }
        fetch('/api/posts', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({ //자바스크립트 객체 → JSON 문자열
                title: getValue('title'),
                writer: getValue("writer"),
                content: getValue("content")
            })
        }).then(response => {
            if(response.ok){
                alert('등록되었습니다.');
                location.replace('/posts');
            }else{
                alert("등록 실패: " + response.status);
            }
        });
    })
}

// 글 삭제 - DELETE /api/posts/{id}
const deleteButton = document.getElementById('delete-btn');
if(deleteButton){
    deleteButton.addEventListener('click', () => {
        if(!confirm('정말 삭제할까요?')) return; //취소
        const id = getValue('post-id');
        fetch(`/api/posts/${id}`, {method: 'DELETE'})
            .then(response => {
                if(response.ok){
                    alert("삭제되었습니다.");
                    location.replace('/posts');
                }else{
                    alert("삭제 실패: " + response.status);
                }
            }
        );
    })
}













