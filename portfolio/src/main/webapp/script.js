// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}














function getComments(val) {
    fetch("/data").then(response.json()).then(comments) => {
    const commentContainer = document.getElementById('comments-list');
    commentContainer.innerHTML="";
    for(let i=0; i<val&& i<=comments.length-1;i++){
        commentContainer.appendChild(createCommentElement(comments[i]));
    }
        });
}
  
/**
 * Handles response by converting it to text and passing the result to
 * addQuoteToDom().
 */
function handleResponse(response) {
  console.log('Handling the response.');

  // response.text() returns a Promise, because the response is a stream of
  // content and not a simple variable.
  const textPromise = response.text();

  // When the response is converted to text, pass the result into the
  // addQuoteToDom() function.
  textPromise.then(addCommentToDom);
}

/** Adds a random quote to the DOM. */
function addCommentToDom(comment) {
  console.log('Adding comment to dom: ' + comment);

  const commentContainer = document.getElementById('comments-container');
  commentContainer.innerText = comment;
}

/**
 * The above code is organized to show each individual step, but we can use an
 * ES6 feature called arrow functions to shorten the code. This function
 * combines all of the above code into a single Promise chain. You can use
 * whichever syntax makes the most sense to you.
 */
function getRandomCommentsUsingArrowFunctions() {
  fetch('/data').then(response => response.text()).then((comment) => {
    document.getElementById('comments-container').innerText = comment;
  });
}

fetch('/data').then(response => response.json()).then((data) => {
    });

/**
 * Another way to use fetch is by using the async and await keywords. This
 * allows you to use the return values directly instead of going through
 * Promises.
 */
async function getRandomCommentsUsingAsyncAwait() {
  const response = await fetch('/data');
  const comment = await response.text();
  document.getElementById('comments-container').innerText = comment;
}
