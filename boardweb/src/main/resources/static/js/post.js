
// 입력값 읽기 함수
function getValue(id){
    return document.getElementById(id).value;
}

// 글 등록 - POST /api/posts, + JSON 데이터
const createButton = document.getElementById('create-btn');
if(createButton){
    createButton.addEventListener('click', () => {
        // 입력값 검증
        if(!getValue('title') || !getValue('content')){
            alert("모든 필드를 입력하세요.");
            return;
        }
        fetch('/api/posts', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({ //자바스크립트 객체 → JSON 문자열
                title: getValue('title'),
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

// 글 수정 PUT /api/posts/{id}
const modifyButton = document.getElementById('modify-btn');
if(modifyButton){
    modifyButton.addEventListener('click', () => {
        const id = getValue('post-id');
        fetch(`/api/posts/${id}`, {
            method: 'PUT',
            headers: { 'Content-type': 'application/json'},
            body: JSON.stringify({
                title: getValue('title'),
                content: getValue('content')
            })
        }).then(response => {
                if(response.ok){
                    alert("수정되었습니다.");
                    location.replace(`/posts/${id}`);
                }else{
                    alert("수정 실패: " + response.status);
                }
            }
        )
    });
}

// ④ AI 제안 — POST /api/ai-suggestions
const aiButton = document.getElementById('ai-btn');
if (aiButton) {
    aiButton.addEventListener('click', () => {
        const question = getValue('ai-question').trim();
        if (!question) {
            alert('AI에게 물어볼 내용을 입력하세요.');
            return;
        }
        const list = document.getElementById('ai-result');
        list.innerHTML = '<li class="list-group-item text-muted">AI가 생각하는 중…</li>';
        aiButton.disabled = true;                      // 응답 올 때까지 다시 못 누르게

        fetch('/api/ai-suggestions', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title: getValue('title'),
                content: getValue('content'),
                question: question
            })
        }).then(response => {
            if (!response.ok) throw new Error(response.status);
            return response.json();
        }).then(data => {
            list.innerHTML = '';
            data.suggestions.forEach(text => {
                const li = document.createElement('li');
                li.className = 'list-group-item list-group-item-action';
                li.style.cursor = 'pointer';
                li.textContent = text;                 // innerHTML 대신 textContent
                li.addEventListener('click', () => {
                    const content = document.getElementById('content');
                    content.value += (content.value ? '\n\n' : '') + text;
                });
                list.appendChild(li);
            });
        }).catch(err => {
            list.innerHTML = '<li class="list-group-item text-danger">AI 응답 실패 : '
                + err.message + '</li>';
        }).finally(() => {
            aiButton.disabled = false;
        });
    });
}












